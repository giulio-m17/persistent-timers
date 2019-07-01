FROM payara/micro:5.183

COPY ./services/sample-service/target/sample-service.war $DEPLOY_DIR
COPY ./logging.properties /opt/payara/logging.properties

CMD ["--deploymentDir","/opt/payara/deployments","--name","member1","--logProperties", "/opt/payara/logging.properties"]