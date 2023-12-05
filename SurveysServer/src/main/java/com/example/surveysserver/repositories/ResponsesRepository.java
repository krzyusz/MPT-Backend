package com.example.surveysserver.repositories;

import com.example.surveysserver.data.Answer;
import com.example.surveysserver.data.Option;
import com.example.surveysserver.data.Response;
import com.example.surveysserver.data.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResponsesRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Response> getAll() {
        return jdbcTemplate.query("SELECT ResponseID, SurveyID, UserID, SubmissionTime FROM Responses",
                BeanPropertyRowMapper.newInstance(Response.class));
    }

    public int save(List<Response> responses) {
        responses.forEach(response -> jdbcTemplate
                .update("INSERT INTO Responses(ResponseID, SurveyID, UserID, SubmissionTime) VALUES(?, ?, ?, ?)",
                        response.getResponseid(),
                        response.getSurveyid(),
                        response.getUserid(),
                        response.getSubmissiontime()
                ));
        return 1;
    }

    //DELETE
    public int delete(Response response) {
        jdbcTemplate.update("DELETE FROM Responses WHERE ResponseID = ?",
                response.getResponseid());
        return 1;
    }

    public Response getResponseById(int id) {
        return jdbcTemplate.queryForObject("SELECT ResponseID, SurveyID, UserID, SubmissionTime FROM Responses WHERE ResponseID = ?",
                BeanPropertyRowMapper.newInstance(Response.class),id);
    }
/*
    @Autowired
    JdbcTemplate jdbcTemplate;


    //GET
    public List<Survey> getAll(){
        return jdbcTemplate.query("SELECT id, imie, nazwisko, ocena FROM danetestowe",
                BeanPropertyRowMapper.newInstance(Survey.class));
    }

    public List<Survey> getSurveysBySurname(String surname){
        return jdbcTemplate.query("SELECT id, imie, nazwisko, ocena FROM danetestowe WHERE nazwisko = ?",
                BeanPropertyRowMapper.newInstance(Survey.class),surname);
    }

    public List<Survey> getSurveysByRate(int rate){
        return jdbcTemplate.query("SELECT id, imie, nazwisko, ocena FROM danetestowe WHERE ocena = ?",
                BeanPropertyRowMapper.newInstance(Survey.class),rate);
    }

    public Survey getSurveysById(int id){
        return jdbcTemplate.queryForObject("SELECT id, imie, nazwisko, ocena FROM danetestowe WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Survey.class),id);
    }


    //POST
    public int save(List<Survey> surveys){
        surveys.forEach(survey -> jdbcTemplate
                .update("INSERT INTO danetestowe(imie, nazwisko, ocena) VALUES(?, ?, ?)",
                        survey.getImie(), survey.getNazwisko(), survey.getOcena()
                ));
        return 1;
    }

    public int save(Survey survey){
        jdbcTemplate.update("INSERT INTO danetestowe(imie, nazwisko, ocena) VALUES (?, ?, ?)",
                        survey.getImie(),survey.getNazwisko(),survey.getOcena());
        return 1;
    }

    //PUT
    public int update(Survey survey){
        jdbcTemplate.update("UPDATE danetestowe SET imie=?, nazwisko=?, ocena=? WHERE id=?",
                survey.getImie(),survey.getNazwisko(),survey.getOcena(),survey.getId());
        return 1;
    }

    public int delete(Survey survey) {
        jdbcTemplate.update("DELETE FROM danetestowe WHERE id=?",
                survey.getId());
        return 1;
    }

 */
}
