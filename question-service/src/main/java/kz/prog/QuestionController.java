package kz.prog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/questions")
public record QuestionController( QuestionService questionService) {

    @PostMapping
    public void registerQuestion (@RequestBody QuestionRegistrationRequest questionRegistrationRequest){
        log.info("new user registration {}", questionRegistrationRequest);
        questionService.registerUser(questionRegistrationRequest);
    }
}