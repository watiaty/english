package com.waitaty.english.service.impl;

import com.waitaty.english.entity.Progress;
import com.waitaty.english.entity.User;
import com.waitaty.english.repository.ProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {
    private final ProgressRepository progressRepository;

    public ProgressService(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    public List<Progress> findByUser(User user) {
        return progressRepository.findByUser(user);
    }

    public Progress save(Progress progress) {
        return progressRepository.save(progress);
    }

    public void deleteById(Long id) {
        progressRepository.deleteById(id);
    }
}
