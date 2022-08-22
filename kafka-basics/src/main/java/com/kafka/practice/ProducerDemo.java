package com.kafka.practice;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {

    private static Logger log= LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());

    public static void main(String[] args) {
       //create properties
        Properties properties=new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        //create kafka producer
        Producer<String,String>producer=new KafkaProducer<>(properties);
        //create producer record
        ProducerRecord<String, String>producerRecord=new ProducerRecord<>("first-topic","produce value from java producer");
        //send the data asyncronous
        producer.send(producerRecord);

        log.info("send record to topic");

        //flush the data syncronous
        producer.flush();
        producer.close();
    }
}
