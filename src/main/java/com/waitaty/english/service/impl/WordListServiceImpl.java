package com.waitaty.english.service.impl;

import com.waitaty.english.entity.StatusWord;
import com.waitaty.english.entity.User;
import com.waitaty.english.entity.WordUserList;
import com.waitaty.english.repository.UserRepository;
import com.waitaty.english.repository.WordListRepository;
import com.waitaty.english.service.WordListService;
import org.springframework.stereotype.Service;

@Service
public class WordListServiceImpl implements WordListService {
    private final WordListRepository wordListRepository;
    private final UserRepository userRepository;

    public WordListServiceImpl(WordListRepository wordListRepository, UserRepository userRepository) {
        this.wordListRepository = wordListRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addNotLearnedWord(String email, Long wordId) {
        User user = userRepository.findByEmail(email).orElseThrow();
        WordUserList wordUserList = new WordUserList();
        wordUserList.setUserId(user.getId());
        wordUserList.setWordId(wordId);
        wordUserList.setStatus(StatusWord.LEARNING);
        wordListRepository.save(wordUserList);
    }

    @Override
    public void addLearningWord(String email, Long wordId) {
        User user = userRepository.findByEmail(email).orElseThrow();
        WordUserList wordUserList = new WordUserList();
        wordUserList.setUserId(user.getId());
        wordUserList.setWordId(wordId);
        wordUserList.setStatus(StatusWord.LEARNING);
        wordListRepository.save(wordUserList);
    }
}
