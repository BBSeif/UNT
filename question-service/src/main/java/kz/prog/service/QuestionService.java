package kz.prog.service;


import kz.prog.entity.Answer;
import kz.prog.entity.Question;
import kz.prog.entity.QuestionRegistrationRequest;
import kz.prog.repository.AnswerRepository;
import kz.prog.repository.QuestionRepository;
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
        questionRepository.save(question);
        log.info("<---------------{} Question is saved !---------------->", question);

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



    }

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public Answer getAnswerById(Long id) {return answerRepository.findById(id).orElse(null);}
}


