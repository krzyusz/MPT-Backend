package com.example.surveysserver.repositories;

import com.example.surveysserver.data.Answer;
import com.example.surveysserver.data.Instructors;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorsRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //GET
    public List<Instructors> getAll(){
        return jdbcTemplate.query("SELECT InstructorID, FirstName, LastName, Email FROM Instructors",
                BeanPropertyRowMapper.newInstance(Instructors.class));
    }


    //POST
    public int save(List<Instructors> instructors){
        instructors.forEach(instructor -> jdbcTemplate
                .update("INSERT INTO Instructors(InstructorID, FirstName, LastName, Email) VALUES(?, ?, ?, ?)",
                        instructor.getInstructorid(),
                        instructor.getFirstname(),
                        instructor.getLastname(),
                        instructor.getEmail()
                ));
        return 1;
    }



/*





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
