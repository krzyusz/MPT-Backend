package com.example.surveysserver.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Option {

    private int optionid;
    private int questionid;
    private String content;
}
