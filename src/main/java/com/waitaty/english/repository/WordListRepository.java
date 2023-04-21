package com.waitaty.english.repository;

import com.waitaty.english.entity.WordUserList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordListRepository extends JpaRepository<WordUserList, Long> {

}
