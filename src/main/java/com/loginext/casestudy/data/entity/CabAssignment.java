package com.loginext.casestudy.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "cab_assignment")
@Entity
public class CabAssignment implements Serializable{

    @Id
    @Column(name = "cabAssignmentId",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cabAssignmentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private CabOrder cabOrder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverId")
    private Driver driver;

    public int getCabAssignmentId() {
        return cabAssignmentId;
    }

    public void setCabAssignmentId(int cabAssignmentId) {
        this.cabAssignmentId = cabAssignmentId;
    }

    public CabOrder getCabOrder() {
        return cabOrder;
    }

    public void setCabOrder(CabOrder cabOrder) {
        this.cabOrder = cabOrder;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
