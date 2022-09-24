#!/bin/bash

CURRENT_PID=$(pgrep -f java) 
echo "CURRENT_PID: $CURRENT_PID"

if [ $CURRENT_PID ]; then
        echo "kill -9 $CURRENT_PID"
        kill -9 $CURRENT_PID
else
        echo "실행중인 프로세스가 없습니다."
fi

sleep 3

cd ~/test
JAR_NAME=$(ls | grep backend)
echo "JAR_NAME: $JAR_NAME"

nohup java -jar $JAR_NAME > /dev/null 2>&1 &
