package kz.prog;


import org.springframework.stereotype.Service;


@Service
public record QuestionService (QuestionRepository questionRepository) {


    public void registerUser(QuestionRegistrationRequest request) {

        Question question = Question.builder()
                .questionText(request.questionText())
                .answers(request.answers())
                .correctAnswers(request.correctAnswers())
                .build();

//        todo: check test content

        questionRepository.save(question);
    }
}


