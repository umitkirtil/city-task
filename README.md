## IMPORTANT ###
To Run this on your local u need to install Docker Runtime first. : https://www.docker.com/products/docker-desktop/

### MongoDB
docker-compose -f mongo-compose.yml up
### Keycloak
docker-compose -f keycloak-postgresql.yml up
### App From CommandLine
./gradlew bootRun


###Note : Make sure you started the mongo and keycloak before the app. 