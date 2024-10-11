package kz.prog;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public record QuestionService (QuestionRepository questionRepository,
                               AnswerRepository answerRepository) {


    public void registerQuestion(QuestionRegistrationRequest request) {


        if (request.getCorrectAnswers().isEmpty() || request.getAnswers().isEmpty()){
            throw new RuntimeException("Answer or Correct Answer is empty! ");
        }

        Question question = Question.builder()
                .questionText(request.getQuestionText())
                .build();


        for (String answer : request.getAnswers()) {
            boolean isCorrect = request.getCorrectAnswers().contains(answer);
            Answer answerObj = Answer.builder()
                    .question(question)
                    .answerText(answer)
                    .isCorrect(isCorrect)
                    .build();
            log.info("<-------------{} Answer is saved !-------------->", answerObj);
            answerRepository.save(answerObj);

        }
        log.info("<---------------{} Question is saved !---------------->", question);
        questionRepository.save(question);

    }

    public List<Question> getAll(){
        return questionRepository.findAll();
    }
}


