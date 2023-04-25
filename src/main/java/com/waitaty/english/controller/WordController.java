package com.waitaty.english.controller;

import com.waitaty.english.entity.User;
import com.waitaty.english.entity.Word;
import com.waitaty.english.service.impl.UserServiceImpl;
import com.waitaty.english.service.impl.WordServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/words")
@RequiredArgsConstructor
public class WordController {
    private final WordServiceImpl wordService;
    private final UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<Word>> getAll() {
        return ResponseEntity.ok(wordService.findAll());
    }

    @GetMapping(path = "/new-words")
    @SecurityRequirement(name = "JWT")
    ResponseEntity<List<Word>> getTwentyWords(Principal principal) {
        User user = userService.findByEmail(principal.getName()).orElseThrow();
        return ResponseEntity.ok(wordService.findWordsNotInUserList(user.getId()));
    }
}
