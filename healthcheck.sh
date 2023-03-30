#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE
echo "Checking if hub is ready - $HUB_HOST"
cat healthcheck.sh
while [ "$( curl -s http://"$HUB_HOST":4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
echo "inside loop"
	sleep 1
done
echo "starting java command"
# start the java command
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* \
    -DHUB_HOST="$HUB_HOST" \
    -DBROWSER="$BROWSER" \
    org.testng.TestNG \
    testng.xml\
    #modeule is hard coded in my script, but not in the course one.