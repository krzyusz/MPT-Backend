package com.example.surveysserver.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassConvert {

    private BigInteger classid;

    private BigInteger courseid;

    private BigInteger instructorid;

}
