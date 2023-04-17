package com.waitaty.english.service.impl;

import com.waitaty.english.entity.Level;
import com.waitaty.english.repository.LevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelService {
    private final LevelRepository levelRepository;

    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public List<Level> findAll() {
        return levelRepository.findAll();
    }

    public Optional<Level> findById(Long id) {
        return levelRepository.findById(id);
    }
}

