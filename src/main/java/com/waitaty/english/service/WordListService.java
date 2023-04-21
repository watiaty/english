package com.waitaty.english.service;

import com.waitaty.english.entity.WordUserList;

public interface WordListService {
    void addNotLearnedWord(String email, Long wordId);

    void addLearningWord(String email, Long wordId);
}
