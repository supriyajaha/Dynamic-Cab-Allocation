package com.loginext.casestudy.data.dao;

import com.loginext.casestudy.data.entity.CabAssignment;
import com.loginext.casestudy.data.entity.CabOrder;
import com.loginext.casestudy.data.entity.Driver;

import java.util.List;

public interface DataDao {
    List<Driver> getAvailableDrivers();

    List<Driver> getAllDrivers();

    void saveCabOrder(CabOrder cabOrder);

    void saveCabAssignment(CabAssignment cabAssignment);

    void updateDriverStatus(Driver driverAssigned);
}
