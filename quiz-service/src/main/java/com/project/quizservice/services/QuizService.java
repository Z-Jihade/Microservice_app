package com.project.quizservice.services;


import com.project.quizservice.entities.Quiz;
import com.project.quizservice.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

   @Autowired
   private QuestionService questionService;

   private QuizRepository quizRepository;

   public ResponseEntity<String> createQuiz(String categoryName, Integer numQuestions, String title) {
       List<Integer> ids = questionService.getQuestionsForQuiz(categoryName, numQuestions);
       Quiz quiz = new Quiz();
       quiz.setTitle(title);
       quiz.setQuestionIds(ids);
       quizRepository.save(quiz);
   }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

    }
}
