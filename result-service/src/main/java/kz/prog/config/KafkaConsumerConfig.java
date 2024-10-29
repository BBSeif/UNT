//package kz.prog.config;
//
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import kz.prog.entity.TestResult;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.mail.MailProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.config.KafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaConsumerConfig {
//
//    @Value("{spring.kafka.bootstrap-servers}")
//    private String bootstrapServers;
//
//    public Map<String, Object> consumerConfig(){
//        Map<String, Object> props = new HashMap<>();
//
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserialize.class);
//        return props;
//    }
//
//    @Bean
//    public ConsumerFactory<String, TestResult> consumerFactory(){
//        return new DefaultKafkaConsumerFactory<>(consumerConfig());
//    }
//
//    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, TestResult>> factory (
//            ConsumerFactory<String, TestResult> consumerFactory
//    ) {
//        ConcurrentKafkaListenerContainerFactory<String, TestResult> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory);
//        return factory;
//    }
//}