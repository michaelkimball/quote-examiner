package dev.michaelkimball.opennlp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExaminedQuote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @With
    @Lob
    private String original;
    @With
    @Lob
    private String stripped;
    @With
    private int nouns;
    @With
    private int verbs;
    @With
    private int periods;
    @With
    private int you;
    @With
    private int that;
    @With
    private int thing;
    @With
    private int they;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable=false)
    @JsonBackReference
    @With
    private User user;
}
