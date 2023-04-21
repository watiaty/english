package com.waitaty.english.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

@Data
@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    private String definition;
    private String partOfSpeech;
    private String exampleSentence;
    @ManyToOne
    @JoinColumn(name = "level_id")
    @JsonIgnore
    private Level level;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    @JsonIgnore
    private Theme theme;
}

