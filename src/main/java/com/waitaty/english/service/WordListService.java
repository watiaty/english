package com.waitaty.english.service;

import com.waitaty.english.entity.Word;
import com.waitaty.english.entity.WordUserList;

import java.util.List;

public interface WordListService {
    void addNotLearnedWord(String email, Long wordId);

    void addLearningWord(String email, Long wordId);

    List<Word> getLearningWordsByUserEmail(String email);

    List<Word> getLearnedWordsByUserEmail(String email);

    List<Word> getWordsByUserEmail(String email);

    int getQuantityLearningWords(String email);

    int getQuantityLearnedWords(String email);
}
