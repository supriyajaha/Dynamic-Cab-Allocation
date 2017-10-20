package com.loginext.casestudy.request_response;

import java.util.ArrayList;
import java.util.List;

public class ShowAllDriversResponse {
    private List<DriverCustomerAssignment> driverCustomerAssignments;

    public List<DriverCustomerAssignment> getDriverCustomerAssignments() {
        if(driverCustomerAssignments==null){
            driverCustomerAssignments = new ArrayList<>();
        }
        return driverCustomerAssignments;
    }

    public void setDriverCustomerAssignments(List<DriverCustomerAssignment> driverCustomerAssignments) {
        this.driverCustomerAssignments = driverCustomerAssignments;
    }
}
