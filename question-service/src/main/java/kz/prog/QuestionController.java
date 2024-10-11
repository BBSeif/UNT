package kz.prog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/questions")
public record QuestionController( QuestionService questionService) {

    @PostMapping
    public void registerQuestion (@RequestBody QuestionRegistrationRequest questionRegistrationRequest){
        log.info("new question registration {}", questionRegistrationRequest);
        questionService.registerQuestion(questionRegistrationRequest);
    }

    @GetMapping("/all")
    public List<Question> getAllQuestions (){
        return questionService.getAll();
    }
}