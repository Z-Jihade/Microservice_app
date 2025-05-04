package com.project.questionservice.controllers;



import com.project.questionservice.entities.Question;
import com.project.questionservice.entities.QuestionWrapper;
import com.project.questionservice.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.questionservice.services.QuestionService;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    Environment environment;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }


    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }
    // generate
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> generateQuestionsForQuiz(@RequestParam String categoryName, @RequestParam int numQuestions){
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }
    // getQuestions (questionid)
    @PostMapping("getQuestionsByIds")
    public ResponseEntity<List<QuestionWrapper>> generateQuestionsByIds(@RequestBody List<Integer> questionIds){
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.generateQuestionsByIds(questionIds);
    }
    // getScore
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }





}
