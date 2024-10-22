package kz.prog;


import kz.prog.entity.TestResult;
import kz.prog.service.TestResultPublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, TestResult> kafkaTemplate){
        TestResult testResult = new TestResult(1L,2L,15);
        return args -> {
            kafkaTemplate.send("test-results", testResult);
        };
    }
}