package com.waitaty.english.service.impl;

import com.waitaty.english.entity.Level;
import com.waitaty.english.entity.Theme;
import com.waitaty.english.entity.Word;
import com.waitaty.english.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {
    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<Word> findByPartOfSpeech(String partOfSpeech) {
        return wordRepository.findByPartOfSpeech(partOfSpeech);
    }

    public List<Word> findByLevelAndTheme(Level level, Theme theme) {
        return wordRepository.findByLevelAndTheme(level, theme);
    }

    public List<Word> findAll() {
        return wordRepository.findAll();
    }
}

