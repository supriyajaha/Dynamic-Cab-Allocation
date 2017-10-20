# Dynamic-Cab-Allocation
Exposed rest api which allocates cab which is closes to customer, operations related to this functionality

# Problem Statement
There are 5 drivers - D1, D2, D3, D4, D5. 
1. Book A Cab Api - If given location of customer and its information, determine which driver needs to be allocated to this customer based on his availability and location.  
2. Show All Drivers Api - Get information of all driver includinf driver name, status, allocated customer

# Pre-requisties
- Java  1.7
- MySql
- Maven



# How to Run Application
- Run the sql file createTable.sql in sql command line    
-   source (file_path)  
- Change databse settings in database.properties  
- Run command - mvn clean install to create war  
- Deploy war on tomcat



# Operations
1. GetDriver - http://localhost:8080/BookCabSolution/rest/cab/getAvailableDriver
{
	"customerName" : "Customer 1",
    "customerLongitude" : "19.20",
    "customerLatitude": "25.45"
}   
   
2. GetAllDrivers : http://localhost:8080/BookCabSolution/rest/cab/getAllDrivers


