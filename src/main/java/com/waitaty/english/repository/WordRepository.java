package com.waitaty.english.repository;

import com.waitaty.english.entity.Level;
import com.waitaty.english.entity.Theme;
import com.waitaty.english.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findByPartOfSpeech(String partOfSpeech);
    List<Word> findByLevelAndTheme(Level level, Theme theme);

    @Query("select w from Word w")
    List<Word> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM Word WHERE word.id NOT IN (SELECT word_list.word_id FROM word_list WHERE word_list.user_id = :userId) limit 20")
    List<Word> findWordsNotInUserList(@Param("userId") Long userId);
}
