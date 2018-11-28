FROM oracle/glassfish:5.0

COPY target/MealSharingV2-1.0-SNAPSHOT.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy/

