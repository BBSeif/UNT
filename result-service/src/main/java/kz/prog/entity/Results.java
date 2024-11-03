package kz.prog.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "results")
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "test_id", nullable = false)
    int testId;

    @Column(name = "user_id", nullable = false)
    int userId;

    @Column(name = "score", nullable = false)
    int score;

}
