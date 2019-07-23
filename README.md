# persistent-timers

Test project to debug persistent EJB timers in Payara Micro.

To launch run the following commands:

```
mvn clean package
docker-compose up --build
# Start the timer
curl -X GET localhost:3095/timers/start-timer
# Restart the container with the timer
docker-compose restart sample-service
```
