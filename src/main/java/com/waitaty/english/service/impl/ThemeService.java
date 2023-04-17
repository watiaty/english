package com.waitaty.english.service.impl;

import com.waitaty.english.entity.Theme;
import com.waitaty.english.repository.ThemeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {
    private final ThemeRepository themeRepository;

    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    public List<Theme> findAll() {
        return themeRepository.findAll();
    }

    public Optional<Theme> findById(Long id) {
        return themeRepository.findById(id);
    }
}

