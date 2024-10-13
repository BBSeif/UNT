package kz.prog.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestSubmission {
    Long testId;
    Long userId;
    Map<Long, Long> selectedAnswers;
}
