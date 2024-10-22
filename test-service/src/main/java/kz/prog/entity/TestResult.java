package kz.prog.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestResult {
    Long testId;
    Long userId;
    int score;
}
