package kz.prog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.prog.entity.TestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class TestResultConsumer {


//    @KafkaListener(topics = "${kafka.topic.test-results}", groupId = "result-group")
//    public void consumeTestResult(TestResult testResult) {
//        log.info("start kafka ... ");
//        // Process and save the test result to the database
//        saveTestResult(testResult);
//    }


    @KafkaListener(topics = "${kafka.topic.test-results}", groupId = "result-group")
    public void consumeTestResult(String message) {  // Temporarily accept String
        log.info("Raw message received: {}", message);

        // Deserialize the message manually to check its content
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TestResult testResult = objectMapper.readValue(message, TestResult.class);
            log.info("Deserialized TestResult: {}", testResult);
            saveTestResult(testResult);
        } catch (IOException e) {
            log.error("Failed to deserialize message to TestResult: {}", e.getMessage());
        }
    }


    private void saveTestResult(TestResult testResult) {
        System.out.println(" it came from kafka : "+testResult);
        // Logic to persist the test result (e.g., using JPA or JDBC)
    }
}
