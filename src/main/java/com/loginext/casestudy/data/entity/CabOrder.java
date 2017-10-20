package com.loginext.casestudy.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "cab_order")
@Entity
public class CabOrder implements Serializable {

    @Id
    @Column(name = "orderId",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column(name="customerName", nullable = false, length = 20)
    private String customerName;

    @Column(name="customerLatitude", nullable = false)
    private double latitude;

    @Column(name="customerLongitude", nullable = false)
    private double longitude;

/*
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "cabAssignmentId")
    private List<CabAssignment> cabAssignments;
*/


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
