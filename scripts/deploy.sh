#!/usr/bin/env bash

REPOSITORY=/home/ec2-user/physical-therapy-app-api
cd $REPOSITORY

APP_NAME=app-api
JAR_NAME=$(ls $REPOSITORY/$APP_NAME/build/libs/ | grep 'app-api.jar' | tail -n 1)
JAR_PATH=$REPOSITORY/$APP_NAME/build/libs/$JAR_NAME

CURRENT_PID=$(pgrep -f $APP_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> 종료할 애플리케이션이 없습니다."
else
  echo "> kill -9 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

# Option  (prod 환경으로 실행하게 될 때, 이 옵션으로 변경해주기!)
echo "> Deploy - $JAR_PATH "
nohup java -jar $JAR_PATH --spring.profiles.active=local > /dev/null 2> /dev/null < /dev/null &

