package kz.prog.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kz.prog.entity.Results;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class TestResultConsumer {

    ResultService resultService;

    @KafkaListener(topics = "${kafka.topic.test-results}", groupId = "result-group")
    public void consumeTestResult(String testResult) {
        log.info("start kafka ... ");
        // Process and save the test result to the database
        saveTestResult(testResult);
    }



    private void saveTestResult(String input) {


        input = input.replace("TestResult(", "").replace(")", "");


        Pattern pattern = Pattern.compile("testId=(\\d+), userId=(\\d+), score=(\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // Extract each part and print it to debug
            String testIdStr = matcher.group(1);
            String userIdStr = matcher.group(2);
            String scoreStr = matcher.group(3);


            try{

                Results results = Results.builder()
                        .testId(Integer.parseInt(testIdStr))
                        .userId(Integer.parseInt(userIdStr))
                        .score(Integer.parseInt(scoreStr))
                        .build();

                System.out.println(" it came from kafka and changed to object !!! ");

                resultService.saveResults(results);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing integer: " + e.getMessage());
            }
        } else {
            System.out.println("Pattern did not match.");
        }


    }
}
