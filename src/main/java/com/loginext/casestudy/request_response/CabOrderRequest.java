package com.loginext.casestudy.request_response;


public class CabOrderRequest {

    private String customerName;

    private double customerLatitude;

    private double customerLongitude;

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerLatitude(double customerLatitude) {
        this.customerLatitude = customerLatitude;
    }

    public void setCustomerLongitude(double customerLongitude) {
        this.customerLongitude = customerLongitude;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getCustomerLatitude() {
        return customerLatitude;
    }

    public double getCustomerLongitude() {
        return customerLongitude;
    }
}
