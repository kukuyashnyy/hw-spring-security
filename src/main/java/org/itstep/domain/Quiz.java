package org.itstep.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "QUIZZES")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "questions")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @OneToMany
    private List<Question> questions;
}
