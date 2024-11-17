package kz.prog;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserMVC {
    private UserService userService;

    public UserMVC(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        model.addAttribute("userRegistrationRequest", new UserRegistrationRequest());
        return "Addauthor";
    }

    @PostMapping
    public String registerUser(@ModelAttribute UserRegistrationRequest userRegistrationRequest, Model model){
        userRegistrationRequest.setRole(Role.STUDENT);
        userService.registerUser(userRegistrationRequest);
        model.addAttribute("message", "User registered successfully!");
        return "success";
    }


    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object statusCode = request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = "An unexpected error occurred";
//        if (statusCode != null) {
//            int status = Integer.parseInt(statusCode.toString());
//            if (status == 404) {
//                return "404";
//            } else if (status == 500) {
//                return "500";
//            }
//        }
        model.addAttribute("message", errorMessage);
        return "error";
    }
}
