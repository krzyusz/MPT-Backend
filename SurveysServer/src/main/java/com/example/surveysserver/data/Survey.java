package com.example.surveysserver.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Survey {

    private int surveyid;

    private String title;

    private String description;

    private int createdby;

    private int classid;
}
