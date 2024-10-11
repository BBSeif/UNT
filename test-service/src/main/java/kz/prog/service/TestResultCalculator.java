package kz.prog.service;

import kz.prog.entity.CorrectAnswer;
import kz.prog.entity.TestResult;
import kz.prog.entity.TestSubmission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;



@Service
public record TestResultCalculator(QuestionServiceClient questionServiceClient) {

    public TestResult calculateTestResult(TestSubmission submission) {
        // Fetch correct answers from Question Service
        List<CorrectAnswer> correctAnswers = questionServiceClient.getCorrectAnswers(submission.getTestId());

        // Calculate the score

        List<Long> selectedAnswers = submission.getSelectedAnswers();

        if (selectedAnswers.size() != correctAnswers.size()) {
            throw new IllegalArgumentException("The size of selected answers and correct answers must be the same.");
        }

        // Compare each selected answer with the correct answer using Streams
        int correctCount = (int)IntStream.range(0, selectedAnswers.size())
                .filter(i -> selectedAnswers.get(i).equals(correctAnswers.get(i).correctAnswerId()))
                .count();

        // Calculate score percentage
        int totalQuestions = correctAnswers.size();
        int score = (correctCount * 100) / totalQuestions;

        // Create the TestResult object
        TestResult result = TestResult.builder()
                .testId(submission.getTestId())
                .userId(submission.getUserId())
                .score(score)
                .correctAnswerIds(submission.getSelectedAnswers())
                .build();

        return result;
    }
}
