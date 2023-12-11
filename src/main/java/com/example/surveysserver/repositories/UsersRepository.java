package com.example.surveysserver.repositories;

import com.example.surveysserver.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    //GET
    public List<User> getAll(){
        return jdbcTemplate.query("SELECT UserID, Username, Password, Email, Type FROM Users",
                BeanPropertyRowMapper.newInstance(User.class));
    }

    //POST
    public int saveUsers(List<User> users){
        users.forEach(user -> jdbcTemplate
                .update("INSERT INTO Users(UserID, Username, Password, Email, Type) VALUES(?, ?, ?, ?, ?)",
                        user.getUserid(),user.getUsername(),user.getPassword(),user.getEmail(),user.getType()));
        return 1;
    }

    public int register(User user) {
        jdbcTemplate.update("INSERT INTO Users(Username, Password, Email, Type) VALUES(?, ?, ?, ?)",
                user.getUsername(),user.getPassword(),user.getEmail(),user.getType());
        return 1;
    }

    public Optional<User> login(User user){
        User user1;
        try {
             user1 = jdbcTemplate.queryForObject("SELECT * FROM users WHERE Username = ? AND Password = ?",
                    BeanPropertyRowMapper.newInstance(User.class),
                    user.getUsername(),
                    user.getPassword());
        } catch(Exception e){
            return Optional.empty();
        }
        return Optional.ofNullable(user1);
    }

    //TODO make login method which returns JWT to user

/*
    public List<Survey> getSurveysBySurname(String surname){
        return jdbcTemplate.query("SELECT id, imie, nazwisko, ocena FROM Users WHERE nazwisko = ?",
                BeanPropertyRowMapper.newInstance(Survey.class),surname);
    }

    public List<Survey> getSurveysByRate(int rate){
        return jdbcTemplate.query("SELECT id, imie, nazwisko, ocena FROM Users WHERE ocena = ?",
                BeanPropertyRowMapper.newInstance(Survey.class),rate);
    }

    public Survey getSurveysById(int id){
        return jdbcTemplate.queryForObject("SELECT id, imie, nazwisko, ocena FROM Users WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Survey.class),id);
    }


    //POST
    public int save(List<Survey> surveys){
        surveys.forEach(survey -> jdbcTemplate
                .update("INSERT INTO Users(imie, nazwisko, ocena) VALUES(?, ?, ?)",
                        survey.getImie(), survey.getNazwisko(), survey.getOcena()
                ));
        return 1;
    }

    public int save(Survey survey){
        jdbcTemplate.update("INSERT INTO Users(imie, nazwisko, ocena) VALUES (?, ?, ?)",
                        survey.getImie(),survey.getNazwisko(),survey.getOcena());
        return 1;
    }

    //PUT
    public int update(Survey survey){
        jdbcTemplate.update("UPDATE Users SET imie=?, nazwisko=?, ocena=? WHERE id=?",
                survey.getImie(),survey.getNazwisko(),survey.getOcena(),survey.getId());
        return 1;
    }

    public int delete(Survey survey) {
        jdbcTemplate.update("DELETE FROM Users WHERE id=?",
                survey.getId());
        return 1;
    }

 */
}
