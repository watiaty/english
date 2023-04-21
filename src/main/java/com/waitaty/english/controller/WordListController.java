package com.waitaty.english.controller;

import com.waitaty.english.dto.request.RegisterRequest;
import com.waitaty.english.dto.request.WordListRequest;
import com.waitaty.english.dto.response.AuthenticationResponse;
import com.waitaty.english.service.impl.WordListServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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
}
