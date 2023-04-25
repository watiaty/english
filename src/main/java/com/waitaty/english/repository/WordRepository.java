package com.waitaty.english.repository;

import com.waitaty.english.entity.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findByPartOfSpeech(String partOfSpeech);

    @Query("select w from Word w")
    List<Word> findAll();

    @Query("SELECT w FROM Word w WHERE w.id NOT IN (SELECT wul.wordId FROM WordUserList wul WHERE wul.userId = :userId)")
    Page<Word> findWordsNotInUserList(@Param("userId") Long userId, Pageable pageable);
}
