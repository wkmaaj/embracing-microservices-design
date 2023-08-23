package llc.jaradatbros.emd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaeldungSpringKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaeldungSpringKafkaApplication.class, args);
    }

    // @Bean
    // public NewTopic topic() {
    //     return TopicBuilder.name("topic").partitions(10).replicas(1).build();
    // }
}
