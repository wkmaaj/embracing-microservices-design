package llc.jaradatbros.emd.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import llc.jaradatbros.emd.domain.model.Greeting;

@Service
public class SendMessageProducerService {

    private KafkaTemplate<String, String> kafkaTemplate;

    private KafkaTemplate<String, Greeting> greetingKafkaTemplate;

    SendMessageProducerService(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, Greeting> greetingKafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.greetingKafkaTemplate = greetingKafkaTemplate;
    }

    public void send(String topicName, Object msg, boolean isAsync, boolean isGreeting) {
        if(isGreeting) {
            greetingKafkaTemplate.send(topicName, (Greeting) msg);
        } else{
        if(isAsync) {
            sendAsynchronously(topicName, (String) msg);
        } else {
            sendSynchronously(topicName, (String) msg);
        }}
    }

    private void sendAsynchronously(String topicName, String msg) {
        kafkaTemplate.send(topicName, msg);
    }

    private void sendSynchronously(String topicName, String msg) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, msg);
        future.whenComplete((res, ex) -> {
            if(ex == null) {
                System.out.println("Sent message=[" + msg + "] with offset=[" + res.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" + msg + "] due to: " + ex.getMessage());
            }
        });
    }
}
