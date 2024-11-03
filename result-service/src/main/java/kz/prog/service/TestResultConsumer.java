package kz.prog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
//import kz.prog.entity.TestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class TestResultConsumer {


    @KafkaListener(topics = "${kafka.topic.test-results}", groupId = "result-group")
    public void consumeTestResult(String testResult) {
        log.info("start kafka ... ");
        // Process and save the test result to the database
        saveTestResult(testResult);
    }



    private void saveTestResult(String testResult) {
        System.out.println(" it came from kafka : "+testResult);
        // Logic to persist the test result (e.g., using JPA or JDBC)
    }
}
