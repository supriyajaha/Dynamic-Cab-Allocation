package com.loginext.casestudy.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "driver")
@Entity
public class Driver implements Serializable {

    @Id
    @Column(name = "driverId",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driverId;

    @Column(name="driverName", nullable = false, length = 20)
    private String driverName;

    @Column(name="latitude", nullable = false)
    private double latitude;

    @Column(name="longitude", nullable = false)
    private double longitude;

    @Column(name="status", nullable = false, length = 10)
    private String status;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId")
    private List<CabAssignment> cabAssignments;

    public List<CabAssignment> getCabAssignments() {
        return cabAssignments;
    }

    public void setCabAssignments(List<CabAssignment> cabAssignments) {
        this.cabAssignments = cabAssignments;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
