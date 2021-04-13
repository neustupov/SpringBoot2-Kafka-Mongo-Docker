# SpringBoot2-Kafka-Mongo-Docker
Spring Boor 2 + Kafka + Mongo + Docker

- Zookeeper - https://zookeeper.apache.org/releases.html#download
- Apache Kafka - https://kafka.apache.org/downloads

For start Zookeeper and Apache Kafka use start-zoo-kafka.bat

For build producer: 
```sh
docker build 
-t producer-img . 
&& docker run 
-p 9090:9092
--name producer
producer-img
```

Check messages in Kafka: 
```sh
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic1 --from-beginning
```

Create network for consumer and mongo: 
```sh
docker network create consumer-network
```

Start consumer + mongo: 
```sh
docker-compose.yaml in consumer main directory
```

Connect to mongo container: 
```sh
docker exec -it consumer-mongo /bin/bash and then mongo
```

Auth in mondodb use command: 
```sh
db.auth("user","user")
```

Check records use command: 
```sh
db.weather.find()
```

