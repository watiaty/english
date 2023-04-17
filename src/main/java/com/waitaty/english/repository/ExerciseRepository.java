package com.waitaty.english.repository;

import com.waitaty.english.entity.Exercise;
import com.waitaty.english.entity.Level;
import com.waitaty.english.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByLevelAndTheme(Level level, Theme theme);
}
