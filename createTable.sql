DROP DATABASE IF EXISTS cab_travel;
CREATE DATABASE IF NOT EXISTS cab_travel;
USE cab_travel;

DROP TABLE IF EXISTS cab_assignment;
DROP TABLE IF EXISTS cab_order;
DROP TABLE IF EXISTS driver;

CREATE TABLE driver(
    driverId    int unsigned NOT NULL auto_increment,
    driverName  varchar(20) NOT NULL,
    latitude    double NOT NULL,
    longitude   double NOT NULL,
    status   varchar(10) DEFAULT 'AVAILABLE',
    PRIMARY KEY(driverId)
);

CREATE TABLE cab_order(
    orderId     int unsigned NOT NULL auto_increment,
    customerName    varchar(20),
    customerLatitude    double NOT NULL,
    customerLongitude   double NOT NULL,
    PRIMARY KEY(orderId)
);

CREATE TABLE cab_assignment(
    cabAssignmentId int unsigned NOT NULL auto_increment,
    orderId     int unsigned,
    driverId    int unsigned,
    PRIMARY  KEY(cabAssignmentId),
    FOREIGN KEY(orderId) REFERENCES cab_order(orderId) ON DELETE CASCADE,
    FOREIGN KEY(driverId) REFERENCES driver(driverId) ON DELETE CASCADE
);

INSERT INTO driver(driverName, latitude, longitude)
VALUES ("Driver 1", 19, 72),
       ("Driver 2", 20, 74),
       ("Driver 3", 25, 30),
       ("Driver 4", 15, 70),
       ("Driver 5", 18, 95);