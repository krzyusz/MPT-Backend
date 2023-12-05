package com.example.surveysserver.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    private int answerid;
    private int responseid;
    private int questionid;
    private int selectedoptionid;
    private String content;


}
