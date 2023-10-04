package br.itau.payment.producer;


import br.itau.payment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;

@Component
public class KafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(final String topic,
                     final String key,
                     final String message) {
        logger.info("sending message to topic {} with key {} - message {}", topic, key, message);
        kafkaTemplate.send(topic, key, message)
                .addCallback(handleSuccess(topic, key, message), handleFailure(topic, key, message));
    }

    private SuccessCallback<? super SendResult<String, String>> handleSuccess(final String topic, final String key, final String message) {
        return result -> logger.info("message sent to topic {} with key {} - message {}", topic, key, message);
    }

    private FailureCallback handleFailure(final String topic, final String key, final String message) {
        return exception -> logger.error("error sending message to topic {} with key {} - error {} message {}", topic, key, exception, message);
    }
}
