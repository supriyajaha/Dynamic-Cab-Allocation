package com.loginext.casestudy.service;

import com.loginext.casestudy.data.dao.DataDao;
import com.loginext.casestudy.data.entity.CabAssignment;
import com.loginext.casestudy.data.entity.CabOrder;
import com.loginext.casestudy.data.entity.Driver;
import com.loginext.casestudy.exception.DriverNotAvailableException;
import com.loginext.casestudy.request_response.CabOrderRequest;
import com.loginext.casestudy.request_response.CabOrderResponse;
import com.loginext.casestudy.request_response.DriverCustomerAssignment;
import com.loginext.casestudy.request_response.ShowAllDriversResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cabService")
public class CabServiceImpl implements CabService {

    public static final String BUSY_DRIVER_STATUS = "BUSY";
    @Autowired
    private DataDao dataDao;

    @Transactional
    public CabOrderResponse getAvailableDriver(CabOrderRequest request) {
        //persist customer request in database
        CabOrder cabOrder = getCabOrder(request);
        dataDao.saveCabOrder(cabOrder);

        //get available drivers
        List<Driver> availableDrivers = dataDao.getAvailableDrivers();
        checkIfDriversAreAvailable(availableDrivers);
        Driver driverAssigned = getClosestDriver(request, availableDrivers);

        //persist this entry in database
        CabAssignment cabAssignment = getCabAssignment(cabOrder, driverAssigned);
        dataDao.saveCabAssignment(cabAssignment);

        //Save status of driver
        driverAssigned.setStatus(BUSY_DRIVER_STATUS);
        dataDao.updateDriverStatus(driverAssigned);


        return getCabOrderResponse(driverAssigned);
    }

    @Transactional
    public ShowAllDriversResponse showAllDrivers() {
        List<Driver> drivers = dataDao.getAllDrivers();
        ShowAllDriversResponse response = new ShowAllDriversResponse();
        for(Driver driver:drivers){
            DriverCustomerAssignment driverCustomerAssignment = new DriverCustomerAssignment();
            List<CabAssignment> cabAssignments = driver.getCabAssignments();
            String customerName = getCustomerName(cabAssignments);
            driverCustomerAssignment.setCustomerName(customerName);
            driverCustomerAssignment.setDriverName(driver.getDriverName());
            driverCustomerAssignment.setStatus(driver.getStatus());
            response.getDriverCustomerAssignments().add(driverCustomerAssignment);
        }
        return response;
    }

    private String getCustomerName(List<CabAssignment> cabAssignments) {
        String customerName=null;
        if(cabAssignments!=null && cabAssignments.size()!=0){
            customerName = cabAssignments.get(0).getCabOrder().getCustomerName();
        }
        return customerName;
    }

    private CabAssignment getCabAssignment(CabOrder cabOrder, Driver driverAssigned) {
        CabAssignment cabAssignment = new CabAssignment();
        cabAssignment.setDriver(driverAssigned);
        cabAssignment.setCabOrder(cabOrder);
        return cabAssignment;
    }

    private void checkIfDriversAreAvailable(List<Driver> availableDrivers) {
        if (availableDrivers.size() == 0) {
            throw new DriverNotAvailableException("All drivers are busy at this moment. Please try again later.");
        }
    }

    private CabOrder getCabOrder(CabOrderRequest request) {
        CabOrder cabOrder = new CabOrder();
        cabOrder.setLatitude(request.getCustomerLatitude());
        cabOrder.setLongitude(request.getCustomerLongitude());
        cabOrder.setCustomerName(request.getCustomerName());
        return cabOrder;
    }

    private Driver getClosestDriver(CabOrderRequest request, List<Driver> availableDrivers) {
        double minimumDistance = Double.MAX_VALUE;
        Driver driverAssigned = availableDrivers.get(0);
        for (Driver driver : availableDrivers) {
            double distBetCustomerAndDriver = computeDistance(request.getCustomerLatitude(), request.getCustomerLongitude(), driver.getLatitude(), driver.getLongitude());
            if (distBetCustomerAndDriver < minimumDistance) {
                minimumDistance = distBetCustomerAndDriver;
                driverAssigned = driver;
            }
        }
        return driverAssigned;
    }

    //construct response, by assigning driver name to the customer
    private CabOrderResponse getCabOrderResponse(Driver driver) {
        CabOrderResponse cabOrderResponse;
        cabOrderResponse = new CabOrderResponse();
        cabOrderResponse.setDriverName(driver.getDriverName());
        return cabOrderResponse;
    }

    // Compute distance between two points given their coordinates
    private double computeDistance(double sourceLat, double sourceLong, double destLat, double destLong) {
        double distSq = Math.pow(destLat - sourceLat, 2) + Math.pow(destLong - sourceLong, 2);
        return Math.sqrt(distSq);
    }

}
