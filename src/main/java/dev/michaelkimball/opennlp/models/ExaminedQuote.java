package dev.michaelkimball.opennlp.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExaminedQuote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
