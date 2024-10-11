package kz.prog.service;

import kz.prog.entity.TestResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestResultPublisher {

    private final KafkaTemplate<String, TestResult> kafkaTemplate;

    @Value("${kafka.topic.test-results}")
    private String testResultsTopic;

    public TestResultPublisher(KafkaTemplate<String, TestResult> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishTestResult(TestResult testResult) {
        kafkaTemplate.send(testResultsTopic, testResult);
    }
}
