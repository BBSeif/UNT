package kz.prog.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionRegistrationRequest {
    String questionText;
    List<String> answers;
    List<String> correctAnswers;
}
