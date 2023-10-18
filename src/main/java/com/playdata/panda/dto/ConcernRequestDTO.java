package com.playdata.panda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ConcernRequestDTO {
    private long user_id;
    private int recruitment_std_id;
}
