package com.waitaty.english.service.impl;

import com.waitaty.english.entity.Level;
import com.waitaty.english.entity.Theme;
import com.waitaty.english.entity.Word;
import com.waitaty.english.repository.WordRepository;
import com.waitaty.english.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    public List<Word> findByPartOfSpeech(String partOfSpeech) {
        return wordRepository.findByPartOfSpeech(partOfSpeech);
    }

    public List<Word> findAll() {
        return wordRepository.findAll();
    }

    public List<Word> findWordsNotInUserList(Long userId) {
        Pageable pageable = PageRequest.of(0, 20);

        Page<Word> wordsPage = wordRepository.findWordsNotInUserList(userId, pageable);

        return wordsPage.getContent();
    }
}

