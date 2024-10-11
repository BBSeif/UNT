package kz.prog;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionRegistrationRequest {
    String questionText;
    List<String> answers;
    List<String> correctAnswers;
}
