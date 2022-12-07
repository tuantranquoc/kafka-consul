package com.example.tiki.configuration;

import com.example.tiki.common.EnumKafkaGroupId;
import com.example.tiki.kafka.KafkaProductConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;
    @Bean
    public ConsumerFactory<String, String> consumingEventStringMessage() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, EnumKafkaGroupId.GROUP_ID_NEW_PRODUCT.name());
        return new DefaultKafkaConsumerFactory<>(configMap);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> listenerEventSendStringMessage() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(consumingEventStringMessage());
        return factory;
    }

    @Bean
    public KafkaProductConsumer receiver() {
        return new KafkaProductConsumer();
    }

}
