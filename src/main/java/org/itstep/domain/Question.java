package org.itstep.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "QUESTIONS")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "answers")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @OneToMany
    private List<Answer> answers;

    @ManyToOne
//    @JoinColumn(name = "quiz_fk")
    private Quiz quiz;
}
