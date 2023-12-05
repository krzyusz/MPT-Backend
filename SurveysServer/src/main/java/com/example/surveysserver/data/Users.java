package com.example.surveysserver.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private int userid;

    private String username;

    private String password;

    private String email;

    private int type;
}
