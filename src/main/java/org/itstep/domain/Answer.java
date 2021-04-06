package org.itstep.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Table(name = "ANSWERS")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    private Boolean correct;

    @ManyToOne
//    @JoinColumn(name = "question_fk")
    private Question question;
}
