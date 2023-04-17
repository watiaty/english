package com.waitaty.english.controller;

import com.waitaty.english.entity.Word;
import com.waitaty.english.service.impl.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/words")
public class WordController {
    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public ResponseEntity<List<Word>> getAll() {
        return ResponseEntity.ok(wordService.findAll());
    }
}
