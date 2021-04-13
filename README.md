# SpringBoot2-Kafka-Mongo-Docker
Spring Boor 2 + Kafka + Mongo + Docker

- Zookeeper - https://zookeeper.apache.org/releases.html#download
- Apache Kafka - https://kafka.apache.org/downloads

For start Zookeeper and Apache Kafka use start-zoo-kafka.bat

For build producer: 
docker build 
-t producer-img . 
&& docker run 
-p 9090:9092
--name producer
producer-img

For check messages in Kafka use: kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic1 --from-beginning

For create network for consumer and mongo - use docker network create consumer-network

For start consumer + mongo use docker-compose.yaml in consumer main directory

For connect to mongo container: docker exec -it consumer-mongo /bin/bash and then mongo

For auth in mondodb use command db.auth("user","user")

For check records use command db.weather.find()


