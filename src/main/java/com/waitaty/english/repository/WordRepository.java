package com.waitaty.english.repository;

import com.waitaty.english.entity.Level;
import com.waitaty.english.entity.Theme;
import com.waitaty.english.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findByPartOfSpeech(String partOfSpeech);
    List<Word> findByLevelAndTheme(Level level, Theme theme);

    @Query("select w from Word w")
    List<Word> findAll();
}
