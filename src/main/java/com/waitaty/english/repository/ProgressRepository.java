package com.waitaty.english.repository;

import com.waitaty.english.entity.Progress;
import com.waitaty.english.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findByUser(User user);
}

