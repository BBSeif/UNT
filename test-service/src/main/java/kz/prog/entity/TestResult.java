package kz.prog.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestResult {
    Long testId;
    Long userId;
    int score;
    List<Long> correctAnswerIds;
}
