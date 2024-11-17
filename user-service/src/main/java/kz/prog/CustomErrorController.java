//package kz.prog;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class CustomErrorController implements ErrorController {
//
//    @GetMapping("/error")
//    public String handleError(HttpServletRequest request, Model model) {
//        // Retrieve the status code
//        Object statusCode = request.getAttribute("jakarta.servlet.error.status_code");
//        String errorMessage = "An unexpected error occurred";
//
//        if (statusCode != null) {
//            int status = Integer.parseInt(statusCode.toString());
//
//            // Return specific error pages based on the status code
//            if (status == 404) {
//                return "404"; // Render 404.html
//            } else if (status == 500) {
//                return "500"; // Render 500.html
//            }
//        }
//
//        // Fallback to a generic error page
//        model.addAttribute("message", errorMessage);
//        return "error";
//    }
//}
