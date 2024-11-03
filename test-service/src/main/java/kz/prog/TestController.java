package kz.prog;

import kz.prog.entity.Question;
import kz.prog.entity.TestResult;
import kz.prog.entity.TestSubmission;
import kz.prog.service.TestResultCalculator;
import kz.prog.service.TestResultPublisher;
import kz.prog.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/tests")
public record TestController(TestService testService,
                             TestResultPublisher testResultPublisher,
                             TestResultCalculator testResultCalculator) {


    @GetMapping("/random-questions")
    public List<Question> getRundomQuestions(@RequestParam int numberOfQuestions){
        log.info("<-----------getting random Questions !----------->");
        return testService.getRandomQuestions(numberOfQuestions);
    }

    @PostMapping("/submit")
    public ResponseEntity<Void> submitTest(@RequestBody TestSubmission submission) {

        log.info("<------------------Test has been submited------------------>");
        TestResult testResult = testResultCalculator.calculateTestResult(submission);

        // Publish the result to Kafka
        testResultPublisher.publishTestResult(testResult.toString());
        log.info("<================= {} send to result-service ==================>",testResult);

        // Optionally, return the result back to the client
        return ResponseEntity.ok().build();
    }
}


