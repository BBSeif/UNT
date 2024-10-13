package kz.prog.service;

import kz.prog.entity.Answer;
import kz.prog.entity.CorrectAnswer;
import kz.prog.entity.Question;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public record QuestionServiceClient(RestTemplate restTemplate) {

    public Question getQuestionById(Long id) {
        return restTemplate.getForObject("http://localhost:8082/api/questions/" + id, Question.class);
    }

    public Answer getAnswerById(Long id) {
        return restTemplate.getForObject("http://localhost:8082/api/questions/answer?id=" + id, Answer.class);
    }

    public List<Question> getAllQuestions() {
        String url = "http://localhost:8082/api/questions/all";
        // Fetch the list of questions from Question Service
        Question[] questions = restTemplate.getForObject(url, Question[].class);
        return Arrays.asList(questions);
    }
}
