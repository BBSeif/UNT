package kz.prog;


import org.springframework.stereotype.Service;

import java.util.List;


@Service
public record QuestionService (QuestionRepository questionRepository) {


    public void registerQuestion(QuestionRegistrationRequest request) {

        if (request.correctAnswers().isEmpty() || request.answers().isEmpty()){
            throw new RuntimeException("Answer or Correct Answer is empty! ");
        }
        Question question = Question.builder()
                .questionText(request.questionText())
                .answers(request.answers())
                .correctAnswers(request.correctAnswers())
                .build();

        questionRepository.save(question);
    }

    public List<Question> getAll(){
        return questionRepository.findAll();
    }
}


