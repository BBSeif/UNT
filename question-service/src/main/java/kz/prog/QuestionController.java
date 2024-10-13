package kz.prog;

import kz.prog.entity.Answer;
import kz.prog.entity.Question;
import kz.prog.entity.QuestionRegistrationRequest;
import kz.prog.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/questions")
public record QuestionController(QuestionService questionService) {

    @PostMapping
    public void registerQuestion (@RequestBody QuestionRegistrationRequest questionRegistrationRequest){
        log.info("new question registration {}", questionRegistrationRequest);
        questionService.registerQuestion(questionRegistrationRequest);
    }

    @GetMapping("/all")
    public List<Question> getAllQuestions (){
        return questionService.getAllQuestions();
    }

    @GetMapping("/answer")
    public Answer getAnswerById(@RequestParam Long id){
        return questionService.getAnswerById(id);
    }
}