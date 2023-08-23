package llc.jaradatbros.emd.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class SendMessageConsumerService {

    @KafkaListener(topics = "topicName", groupId="baeldung-spring-kafka")
    public void listenGroupBaeldungSpringKafka(String msg) {
        System.out.println("Received message in group baeldung-spring-kafka: " + msg);
    }

    @KafkaListener(topics = "topic1, topic2", groupId="kafkajs-crash-course")
    public void listenGroupKafkaJsCrashCourseWithHeaders(@Payload String msg, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        System.out.println("Received message in group kafkajs-crash-course: " + msg + ", from partition: " + partition);
    }

    @KafkaListener(
        topicPartitions = @TopicPartition(
            topic = "topicName",
            partitions = {"0", "1", "2", "3"}),
        containerFactory = "filterKafkaListenerContainerFactory"
    )
    public void listenGroupBaeldungSpringKafkaPartition(
        @Payload String msg, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition
    ) {
        System.out.println("Received msg: " + msg + ", from partition: " + partition);
    }

    @KafkaListener(
        topicPartitions = @TopicPartition(
            topic = "topicName",
            partitionOffsets = {
                @PartitionOffset(partition = "0", initialOffset = "0"),
                @PartitionOffset(partition = "3", initialOffset = "0")})
        // containerFactory = "partitionsKafkaListenerContainerFactory"
    )
    public void listenGroupBaeldungSpringKafkaPartitionOffset(
        @Payload String msg, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition
    ) {
        System.out.println("Received msg: " + msg + ", from partition: " + partition);
    }

}
