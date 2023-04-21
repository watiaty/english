package com.waitaty.english.dto.request;

import com.waitaty.english.entity.User;
import com.waitaty.english.entity.Word;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WordListRequest {
    private Long wordId;
}
