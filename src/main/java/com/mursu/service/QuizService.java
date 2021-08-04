package com.mursu.service;

import com.mursu.model.exam.Category;
import com.mursu.model.exam.Quiz;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface QuizService {

     public Quiz addQuiz(Quiz quiz);
     public Quiz updateQuiz(Quiz quiz);
     public Set<Quiz> getQuizzes();
     public Quiz getQuiz(Long quizId);
     public void deleteQuiz(Long quizId);

    public List<Quiz> getQuizzesOfCategory(Category category);

    public List<Quiz> getActiveQuizzes();
     public List<Quiz> getActiveQuizzesOfCategory(Category category);

}
