# Loyalty Service project

This Project Handle the Basic Loyalty Program Services e.g. create account, add transaction, redeem points, etc.  
The Service connect to MySQL DB and in production mode, it requires the following environment variables:  
PORT = this is the application listening port (8080)  
DB_USER = this is the DB user (loyalty)  
DB_PASSWORD = this is the DB user password (loyalty)  
DB_IP = This is the DB IP address, it point to loyaltymysql (need to map to db IP)  
DB_PORT = This is the DB listening port (3306)  

To run for development:   

```
mvn clean spring-boot:run  

```

This project uses SpringBoot.
