package com.example.surveysserver.repositories;

import com.example.surveysserver.data.ClassConvert;
import com.example.surveysserver.data.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    //GET
    public List<ClassConvert> getAll(){
        return jdbcTemplate.query("SELECT ClassID, CourseID, InstructorID FROM Class",
                BeanPropertyRowMapper.newInstance(ClassConvert.class));
    }

    //POST
    public int save(List<ClassConvert> classConverts){
        classConverts.forEach(classConvert -> jdbcTemplate
                .update("INSERT INTO Class(ClassID, CourseID, InstructorID) VALUES(?, ?, ?)",
                        classConvert.getClassid(), classConvert.getCourseid(), classConvert.getInstructorid()
                ));
        return 1;
    }


/*
    //TODO Pozmieniac w reszcie zapytan paramety
    public List<Survey> getSurveysBySurname(String surname){
        return jdbcTemplate.query("SELECT id, imie, nazwisko, ocena FROM Surveys WHERE nazwisko = ?",
                BeanPropertyRowMapper.newInstance(Survey.class),surname);
    }

    public List<Survey> getSurveysByRate(int rate){
        return jdbcTemplate.query("SELECT id, imie, nazwisko, ocena FROM Surveys WHERE ocena = ?",
                BeanPropertyRowMapper.newInstance(Survey.class),rate);
    }

    public Survey getSurveysById(int id){
        return jdbcTemplate.queryForObject("SELECT id, imie, nazwisko, ocena FROM Surveys WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Survey.class),id);
    }




    public int save(Survey survey){
        jdbcTemplate.update("INSERT INTO Surveys(imie, nazwisko, ocena) VALUES (?, ?, ?)",
                        survey.getImie(),survey.getNazwisko(),survey.getOcena());
        return 1;
    }

    //PUT
    public int update(Survey survey){
        jdbcTemplate.update("UPDATE Surveys SET imie=?, nazwisko=?, ocena=? WHERE id=?",
                survey.getImie(),survey.getNazwisko(),survey.getOcena(),survey.getId());
        return 1;
    }

    public int delete(Survey survey) {
        jdbcTemplate.update("DELETE FROM Surveys WHERE id=?",
                survey.getId());
        return 1;
    }

    */

}
