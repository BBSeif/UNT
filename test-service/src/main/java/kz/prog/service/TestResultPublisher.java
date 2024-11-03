package kz.prog.service;

import kz.prog.entity.TestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestResultPublisher {

    private final KafkaTemplate<Object, String> kafkaTemplate;

    @Value("${kafka.topic.test-results}")
    private String testResultsTopic;

    public TestResultPublisher(KafkaTemplate<Object, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishTestResult(String testResult) {
        kafkaTemplate.send(testResultsTopic, testResult);

        log.info("Message send to topic : {} ",testResultsTopic);
    }
}
