package com.waitaty.english.service.impl;

import com.waitaty.english.entity.Exercise;
import com.waitaty.english.entity.Level;
import com.waitaty.english.entity.Theme;
import com.waitaty.english.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> findByLevelAndTheme(Level level, Theme theme) {
        return exerciseRepository.findByLevelAndTheme(level, theme);
    }

    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void deleteById(Long id) {
        exerciseRepository.deleteById(id);
    }
}
