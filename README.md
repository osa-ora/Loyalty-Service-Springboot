# Loyalty Service project

This Project is based on SpringBoot framework to handle the Basic Loyalty Program Services e.g. create account, add transaction, redeem points, etc.  
  
The Service connect to MySQL DB and in production mode, it requires the following environment variables:  
- PORT = this is the application listening port (8080)  
- DB_USER = this is the DB user (loyalty)  
- DB_PASSWORD = this is the DB user password (loyalty)  
- DB_IP = This is the DB IP address, it point to loyaltymysql (need to map to db IP)  
- DB_PORT = This is the DB listening port (3306)  

The values are hardcoded in application.properties, you can modify them to use the environment variables, also you can create a new profiles for different values.  
To run for development:   

```
mvn clean spring-boot:run  

```
To deploy on OpenShift from your machine:  
1-Update the OpenShift namespace in the pom_ocp.xml file   
2-Login to Openshift using oc login command  
3-Execute To run for development:   

```
mvn -f pom_ocp.xml clean fabric8:deploy -DskipTests  

```

Or You can deploy it from OpenShift GUI or by executing the OC commands:

```
oc new-app registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift~https://github.com/osa-ora/Loyalty-Service-Springboot.git --name=loyalty-service -p JAVA_IMAGE_STREAM_TAG=8

oc expose svc/loyalty-service

```
Note: Make sure the DB loyaltymysql is up and running with schema loaded (import.sql)  

You can create MySQL DB from OpenShift GUI or by executing the OC commands:

```
oc new-app mysql-persistent -p DATABASE_SERVICE_NAME=loyaltymysql -p  MYSQL_ROOT_PASSWORD=loyalty -p MYSQL_DATABASE=loyalty -p MYSQL_USER=loyalty -p MYSQL_PASSWORD=loyalty -p MEMORY_LIMIT=512Mi -p VOLUME_CAPACITY=512Mi

```
Then you can access the Pod and install the DB schema by oc rsh {POD_NAME}  
