package com.waitaty.english.repository;

import com.waitaty.english.entity.Word;
import com.waitaty.english.entity.WordUserList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordListRepository extends JpaRepository<WordUserList, Long> {
    @Query("SELECT w FROM WordUserList wul " +
            "JOIN Word w ON wul.wordId = w.id " +
            "WHERE wul.userId = :userId and wul.status = 'LEARNING'")
    List<Word> findLearningWordsByUserId(@Param("userId") Long userId);

    @Query("SELECT w FROM WordUserList wul " +
            "JOIN Word w ON wul.wordId = w.id " +
            "WHERE wul.userId = :userId and wul.status = 'LEARNED' OR wul.status = 'NOT_LEARNING'")
    List<Word> findLearnedWordsByUserId(@Param("userId") Long userId);

    @Query("SELECT w FROM WordUserList wul " +
            "JOIN Word w ON wul.wordId = w.id " +
            "WHERE wul.userId = :userId")
    List<Word> findAllWordsByUserId(@Param("userId") Long userId);

    @Query("SELECT COUNT(wul) FROM WordUserList wul " +
            "WHERE wul.userId = :userId AND wul.status = 'LEARNING'")
    int getQuantityLearningWords(@Param("userId") Long userId);

    @Query("SELECT COUNT(wul) FROM WordUserList wul " +
            "WHERE wul.userId = :userId AND wul.status = 'LEARNED' OR wul.status = 'NOT_LEARNING'")
    int getQuantityLearnedWords(@Param("userId") Long userId);
}
