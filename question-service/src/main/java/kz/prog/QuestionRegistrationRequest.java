package kz.prog;

import java.util.List;

public record QuestionRegistrationRequest (
        String questionText,
        List<String> answers,
        List<String> correctAnswers
){
}
