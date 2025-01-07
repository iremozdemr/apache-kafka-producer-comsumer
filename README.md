# Kafka Producer and Consumer Project

This project demonstrates a simple Kafka Producer and Consumer setup using Java and Apache Kafka.

---

## **Project Overview**

- **ProducerApp:** Publishes messages to a Kafka topic (`search`) using `KafkaProducer`.
- **ConsumerApp:** Consumes messages from the Kafka topic (`search`) using `KafkaConsumer`.

---

## **Prerequisites**

Make sure you have the following tools installed:

1. **Apache Kafka**  
   [Download Kafka](https://kafka.apache.org/downloads)

2. **Java Development Kit (JDK 11 or higher)**  
   [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

3. **Apache Maven**  
   [Download Maven](https://maven.apache.org/download.cgi)

4. **Kafka Broker Running**  
   Start Zookeeper and Kafka broker:
   ```bash
   ./kafka_2.13-3.0.0/bin/zookeeper-server-start.sh config/zookeeper.properties
   ./kafka_2.13-3.0.0/bin/kafka-server-start.sh config/server.properties

---

## **Project Setup**

1. Clone the repository
    ```bash
    git clone <repository-url>
    cd kafka-java

2. Build the Maven project
    ```bash
    mvn clean install

---

## **How to Run the Project**

1. Create a topic named search:
    ```bash
    ./kafka_2.13-3.0.0/bin/kafka-topics.sh --create --topic search --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

Verify the topic
    ```bash
    ./kafka_2.13-3.0.0/bin/kafka-topics.sh --describe --topic search --bootstrap-server localhost:9092

2. Start the Producer
    Run the producer application to send messages:
    ```bash
    mvn exec:java -Dexec.mainClass="com.example.ProducerApp"

3. Start the Consumer
    ```bash
    mvn exec:java -Dexec.mainClass="com.example.ConsumerApp"

4. Verify Messages with Kafka Console Consumer
    You can also verify messages using Kafka CLI:
    ```bash
    ./kafka_2.13-3.0.0/bin/kafka-console-consumer.sh --topic search --bootstrap-server localhost:9092 --from-beginning

---

## **Project Structure**

```bash
src/
├── main/
│   ├── java/
│   │   └── com/example/
│   │       ├── ProducerApp.java
│   │       ├── ConsumerApp.java
│   ├── resources/
│       └── log4j.properties
└── pom.xml