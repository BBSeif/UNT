package kz.prog;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "questions")
//@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) // Register JSONB type
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String questionText;


    @ElementCollection
    @CollectionTable(name = "question_answers", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "answer")
    List<String> answers;

    @ElementCollection
    @CollectionTable(name = "question_correct_answers", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "correct_answer")
    List<String> correctAnswers;



//    @Column(columnDefinition = "jsonb")
//    List<String> answers;
//
//    @Column(columnDefinition = "jsonb")
//    List<String> correctAnswers;


//    List<String> answers;
//
////    @Column(name = "correct_answer", nullable = false)
//    List<String> correctAnswers;

}
