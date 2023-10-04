package br.itau.payment.configuration;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class KafkaClientConfiguration {
    @Autowired
    private final KafkaProperties kafkaProperties;

    public KafkaClientConfiguration(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(final ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

//    @Bean
//    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaContainerFactory() {
//        val consumerFactory = new DefaultKafkaConsumerFactory<String, String>(kafkaProperties.buildConsumerProperties());
//
//        val factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
//        factory.setConcurrency(kafkaProperties.getListener().getConcurrency());
//        factory.setConsumerFactory(consumerFactory);
//        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.RECORD);
//        return factory;
//    }
//
//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        val configs = kafkaProperties.buildProducerProperties();
//        return new DefaultKafkaProducerFactory<>(configs);
//    }


}
