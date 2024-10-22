package kz.prog.service;

import kz.prog.entity.TestResult;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TestResultConsumer {

    @KafkaListener(topics = "${kafka.topic.test-results}", groupId = "result-group")
    public void consumeTestResult(TestResult testResult) {
        // Process and save the test result to the database
        saveTestResult(testResult);
    }

    private void saveTestResult(TestResult testResult) {
        System.out.println(" it came from kafka : "+testResult);
        // Logic to persist the test result (e.g., using JPA or JDBC)
    }
}
