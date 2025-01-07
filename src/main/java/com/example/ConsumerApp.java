package com.example;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerApp {
    public static void main(String[] args) {
        Properties config = new Properties();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, new StringDeserializer().getClass().getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, new StringDeserializer().getClass().getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"mygroupid");
        config.put(ConsumerConfig.CLIENT_ID_CONFIG,"myclientid");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(config);

        consumer.subscribe(Arrays.asList("search"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("topic: " + record.topic());
                System.out.println("key: " + record.key());
                System.out.println("value: " + record.value());
                System.out.println("offset: " + record.offset());
                System.out.println();
            }
        }
    }
}

//$ ./kafka_2.13-3.0.0/bin/kafka-console-producer.sh --topic search --bootstrap-server localhost:9092