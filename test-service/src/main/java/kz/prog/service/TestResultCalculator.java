package kz.prog.service;

import kz.prog.entity.*;
import kz.prog.repository.AnswerRepository;
import kz.prog.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Slf4j
@Service
public record TestResultCalculator(QuestionServiceClient questionServiceClient) {

    public TestResult calculateTestResult(TestSubmission submission) {


        int score = 0;
        int maxScore = submission.getSelectedAnswers().size();

        for (Map.Entry<Long, Long> entry : submission.getSelectedAnswers().entrySet()){
            Answer selectedAnswer = questionServiceClient.getAnswerById(entry.getValue());
            log.info("<===================={} is selected !====================>", selectedAnswer);

            Boolean isCorrect = selectedAnswer.getIsCorrect();

            if (isCorrect){
                score++;
            }
        }

        // Create the TestResult object
        TestResult result = TestResult.builder()
                .testId(submission.getTestId())
                .userId(submission.getUserId())
                .score(score)
                .build();

        return result;
    }
}
