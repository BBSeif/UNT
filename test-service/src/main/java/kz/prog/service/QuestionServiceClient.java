package kz.prog.service;

import kz.prog.entity.CorrectAnswer;
import kz.prog.Question;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public record QuestionServiceClient(RestTemplate restTemplate) {

    public Question getQuestionById(Long id) {
        return restTemplate.getForObject("http://localhost:8082/api/questions/" + id, Question.class);
    }

    public List<CorrectAnswer> getCorrectAnswers(Long testId) {
        String url = "http://localhost:8082/api/tests/" + testId + "/correct-answers";
        // Fetch the correct answers from the Question Service
        CorrectAnswer[] correctAnswers = restTemplate.getForObject(url, CorrectAnswer[].class);
        return Arrays.asList(correctAnswers);  // Convert the array to a List
    }

    public List<Question> getAllQuestions() {
        String url = "http://localhost:8082/api/questions/all";
        // Fetch the list of questions from Question Service
        Question[] questions = restTemplate.getForObject(url, Question[].class);
        return Arrays.asList(questions);
    }
}
