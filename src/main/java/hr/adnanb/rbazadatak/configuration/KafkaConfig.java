package hr.adnanb.rbazadatak.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.admin.NewTopic;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic createTopic() {
        return new NewTopic("rbazadatak-topic", 3, (short) 1);
    }
}
