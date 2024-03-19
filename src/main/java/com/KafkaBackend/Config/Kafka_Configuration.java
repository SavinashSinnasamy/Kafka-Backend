package com.KafkaBackend.Config;

import com.KafkaBackend.DataTransferObject.FormObject;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Kafka_Configuration {

    @Bean
    public NewTopic creatingTopic(){
        return TopicBuilder.name("FormFlexaUserDetails").build();
    }
//making all the packages in the project as trusted to serialize and deserialize

    @Bean
    public ConsumerFactory<String, FormObject> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka-broker-container:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "requestingBanks");
        // other consumer properties
        JsonDeserializer<FormObject> deserializer = new JsonDeserializer<>(FormObject.class);
        deserializer.addTrustedPackages("com.KafkaBackend.Config"); // Set trusted packages

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new ErrorHandlingDeserializer<>(deserializer));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, FormObject> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, FormObject> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
