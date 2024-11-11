

package kz.prog;

import kz.prog.entity.Answer;
import kz.prog.entity.Question;
import kz.prog.entity.QuestionRegistrationRequest;
import kz.prog.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("questions")
public class QuestionMVC {

    private final QuestionService questionService;

    public QuestionMVC(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("questionRegistrationRequest", new QuestionRegistrationRequest());
        return "question-register";
    }

    @PostMapping("/register")
    public String registerQuestion(@ModelAttribute QuestionRegistrationRequest questionRegistrationRequest) {
        log.info("New question registration: {}", questionRegistrationRequest);
        questionService.registerQuestion(questionRegistrationRequest);
        return "redirect:/questions/all";
    }

    @GetMapping("/all")
    public String getAllQuestions(Model model) {
        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);
//        return "question-list";
        return "QuestionList";
    }

    @GetMapping("/answer")
    public String getAnswerById(@RequestParam Long id, Model model) {
        Answer answer = questionService.getAnswerById(id);
        model.addAttribute("answer", answer);
        return "answer-detail";
    }
}