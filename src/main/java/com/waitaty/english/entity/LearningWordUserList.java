package com.waitaty.english.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "learn_word_user_list")
@PrimaryKeyJoinColumn(name="word_user_list_id")
public class LearningWordUserList extends WordUserList{
    @Column(name = "choose")
    private boolean choose;

    @Column(name = "compose")
    private boolean compose;

    @Column(name = "write")
    private boolean write;
}
