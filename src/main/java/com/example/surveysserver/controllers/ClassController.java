package com.example.surveysserver.controllers;

import com.example.surveysserver.data.ClassConvert;
import com.example.surveysserver.data.Users;
import com.example.surveysserver.repositories.ClassRepository;
import com.example.surveysserver.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/surveys")
public class ClassController {

    @Autowired
    ClassRepository classRepository;

/*
    @GetMapping("/surveys")
    public List<Survey> getAllSurveys(){
        return surveyRepository.getAll();
    }

 */

    @GetMapping("/classes")
    public List<ClassConvert> getAllClasses(){
        return classRepository.getAll();
    }

    @PostMapping("/classes")
    public int addUsers(@RequestBody List<ClassConvert> classes){return classRepository.save(classes);}

    /*
    @GetMapping("/answers")
    public List<Survey> getAllAnswers(){
        return answersRepository.getAll();
    }

    @GetMapping("/courses")
    public List<Survey> getAllCourses(){
        return coursesRepository.getAll();
    }
    @GetMapping("/courseInstructors")
    public List<Survey> getAllCourseInstructors(){
        return courseInstructorsRepository.getAll();
    }

    @GetMapping("/instructions")
    public List<Survey> getAllInstructions(){
        return instructionsRepository.getAll();
    }
    @GetMapping("/options")
    public List<Survey> getAllOptions(){
        return optionsRepository.getAll();
    }

    @GetMapping("/questions")
    public List<Survey> getAllQuestions(){
        return questionsRepository.getAll();
    }
    @GetMapping("/responses")
    public List<Survey> getAllResponses(){
        return responsesRepository.getAll();
    }


    @GetMapping("/test")
    public List<ClassConvert> getAll(){
        return testoweRepository.getAll();
    }

     */

/*

    @GetMapping("/surveys/{rate}")
    public List<Survey> getSurveysByRate(@PathVariable("rate") Integer rate){
        return surveyRepository.getSurveysByRate(rate);
    }

    @PostMapping("/surveys/list")
    public int add(@RequestBody List<Survey> surveys){
            return surveyRepository.save(surveys);
    }

    @PostMapping("/surveys/one")
    public int add(@RequestBody Survey survey){
        return surveyRepository.save(survey);
    }

    @PutMapping("/surveys/{id}")
    public int update(@PathVariable("id") int id,@RequestBody Survey surveyToUpdate){
        try{
            Survey survey = surveyRepository.getSurveysById(id);
            survey.setImie(surveyToUpdate.getImie());
            survey.setNazwisko(surveyToUpdate.getNazwisko());
            survey.setOcena(surveyToUpdate.getOcena());
            return surveyRepository.update(survey);
        }catch(EmptyResultDataAccessException e){
            return -1;
        }
    }


    @DeleteMapping("/surveys/{id}")
    public int delete(@PathVariable("id") int id){
        try {
            Survey survey = surveyRepository.getSurveysById(id);
            return surveyRepository.delete(survey);
        }catch(EmptyResultDataAccessException e){
            return -1;
        }
    }
*/

}
