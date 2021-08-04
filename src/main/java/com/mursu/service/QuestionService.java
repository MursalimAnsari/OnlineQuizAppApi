package com.mursu.service;

import com.mursu.model.exam.Question;
import com.mursu.model.exam.Quiz;

import java.util.Set;


public interface QuestionService {

      public Question addQuestion(Question question);
      public Question updateQuestion(Question question);
      public Set<Question> getQuestions();
      public Question getQuestion(Long questionId);
      public  void deleteQuestion(Long quesId);
      public Set<Question> getQuestionsOfQuiz(Quiz quiz);


}
