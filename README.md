# Kafka Consumer Service

Demo Spring Boot Kafka Consumer Service.

## Feature
- Listen Message String
- Listen Message String Bulk
- Listen Message Object

## Pre Required
- Java 17
- Spring Boot 3.5.6
- Kafka 4.1.0

## Kafka
Create Topic
```
bin/kafka-topics.sh --bootstrap-server localhost:9094 \
--create --topic message-string-topic \
--partitions 3 \
--replication-factor 1 \
--config retention.ms=86400000
```

```
bin/kafka-topics.sh --bootstrap-server localhost:9094 \
--create --topic customer-string-topic \
--partitions 3 \
--replication-factor 1 \
--config retention.ms=86400000
```

Note: im running my Kafka on port 9094
