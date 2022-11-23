## PLEASE READ BEFORE RUN ###
To Run this on your local u need to install Docker Runtime first. : https://www.docker.com/products/docker-desktop/

### MongoDB
docker-compose -f mongo-compose.yml up
### Keycloak
docker-compose -f keycloak-postgresql.yml up
### App From CommandLine
./gradlew bootRun


###Some Explanation :

 - This project uses stateless auth with OAuth2 Standart. (Keycloak)
 - There is 2 controllers. One for public and another for ALLOW_EDIT role.
 
 - I imported the csv you sent. If you just run mongo-compose it will use inner directory for database. If you start a new mongo db it will insert those datas to new mongo.
 - i would use Spring Batch for such an import task but there is only 1000 city so i didnt use that.
 - You can use Kuehne Nagel postman collection to test this backend. Its under resources folder.

##Any further question you can email me : umitkirtil@gmail.com

###Note : Make sure you started the mongo and keycloak before the app. 
