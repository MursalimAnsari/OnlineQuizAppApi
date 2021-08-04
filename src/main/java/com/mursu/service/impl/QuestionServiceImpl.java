package com.mursu.service.impl;

import com.mursu.model.exam.Question;
import com.mursu.model.exam.Quiz;
import com.mursu.repo.QuestionRepository;
import com.mursu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {



     @Autowired
     private QuestionRepository questionRepository;


    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return  new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public  void deleteQuestion(Long quesId) {

       this.questionRepository.deleteById(quesId);
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return new HashSet<>(this.questionRepository.findByQuiz(quiz));
    }
}
