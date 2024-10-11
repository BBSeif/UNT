package kz.prog.service;

import kz.prog.Question;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public record TestService(QuestionServiceClient questionServiceClient) {

    public List<Question> getRandomQuestions(int numberOfQuestions) {
        // Fetch all available questions from the Question Service
        List<Question> allQuestions = questionServiceClient.getAllQuestions();

        // Shuffle the list to get random questions
        Collections.shuffle(allQuestions);

        // Return a sublist with the desired number of questions
        return allQuestions.stream()
                .limit(numberOfQuestions)
                .collect(Collectors.toList());
    }
}
