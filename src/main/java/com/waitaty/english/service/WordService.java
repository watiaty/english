package com.waitaty.english.service;

import com.waitaty.english.entity.Level;
import com.waitaty.english.entity.Theme;
import com.waitaty.english.entity.Word;

import java.util.List;

public interface WordService {
    List<Word> findAll();
    List<Word> findWordsNotInUserList(Long userId);
    List<Word> findByPartOfSpeech(String partOfSpeech);
}
