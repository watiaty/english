package com.waitaty.english.controller;

import com.waitaty.english.dto.request.RegisterRequest;
import com.waitaty.english.dto.request.WordListRequest;
import com.waitaty.english.dto.response.AuthenticationResponse;
import com.waitaty.english.entity.Word;
import com.waitaty.english.service.impl.WordListServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/wordlist")
@RequiredArgsConstructor
public class WordListController {
    private final WordListServiceImpl wordListService;

    @PostMapping("/learning")
    @SecurityRequirement(name = "JWT")
    public void addLearningWord(@RequestBody WordListRequest request, Principal principal) {
        wordListService.addLearningWord(principal.getName(), request.getWordId());
    }

    @PostMapping("/not-learning")
    @SecurityRequirement(name = "JWT")
    public void addNotLearningWord(@RequestBody WordListRequest request, Principal principal) {
        wordListService.addNotLearnedWord(principal.getName(), request.getWordId());
    }

    @GetMapping("/learning")
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<List<Word>> getLearning(Principal principal) {
        return ResponseEntity.ok(wordListService.getLearningWordsByUserEmail(principal.getName()));
    }

    @GetMapping("/learned")
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<List<Word>> getLearned(Principal principal) {
        return ResponseEntity.ok(wordListService.getLearnedWordsByUserEmail(principal.getName()));
    }

    @GetMapping("/all")
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<List<Word>> getAll(Principal principal) {
        return ResponseEntity.ok(wordListService.getWordsByUserEmail(principal.getName()));
    }

    @GetMapping("/count-learning-words")
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<Integer> getCountLearningWords(Principal principal) {
        return ResponseEntity.ok(wordListService.getQuantityLearningWords(principal.getName()));
    }

    @GetMapping("/count-learned-words")
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<Integer> getCountLearnedWords(Principal principal) {
        return ResponseEntity.ok(wordListService.getQuantityLearnedWords(principal.getName()));
    }
}
