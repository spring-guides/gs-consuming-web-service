#!/bin/sh

cd /tmp
git clone https://github.com/spring-guides/gs-producing-web-service
(cd gs-producing-web-service/complete; ./mvnw clean install spring-boot:run &)

sleep 10

cd ../complete

./mvnw clean package
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf target

./gradlew build
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf build

cd ../initial

./mvnw clean spring-boot:run
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf target

./gradlew bootRun
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf build

pkill -f spring-boot:run

exit
