package com.mursu.controller;

import com.mursu.model.exam.Question;
import com.mursu.model.exam.Quiz;
import com.mursu.service.QuestionService;
import com.mursu.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
    @CrossOrigin("*")
    @RequestMapping("/question")
    public class QuestionController {

     @Autowired
      private QuestionService questionService;

     @Autowired
     private QuizService quizService;

        //add question
        @PostMapping("/")
        public ResponseEntity<Question> addQuestion(@RequestBody Question question){
            return ResponseEntity.ok(this.questionService.addQuestion(question));
        }

        // update question...
        @PutMapping("/")
        public ResponseEntity<Question> updateQuestion(@RequestBody Qu estion question){
            return  ResponseEntity.ok( this.questionService.updateQuestion(question));
        }

       // gets selected questions of any quiz...
        @GetMapping("/quiz/{qid}")
       public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){

            Quiz quiz = this.quizService.getQuiz(qid);
            Set<Question> questions = quiz.getQuestions();
            List list = new ArrayList(questions);

            if(list.size()> Integer.parseInt((quiz.getNumberOfQuestions()))){
                list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
            }
            Collections.shuffle(list);
            return ResponseEntity.ok(list);

        }


    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid){

        Quiz quiz = new Quiz();
        quiz.setQid(qid);
        Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
        return  ResponseEntity.ok(questionsOfQuiz);

    }

         //get single question...
        @GetMapping("/{quesId}")
        public Question getQuestion(@PathVariable("quesId") Long quesId){
            return  this.questionService.getQuestion(quesId);
        }

        // delete Question
        @DeleteMapping("/{quesId}")
        public void deleteQuestion(@PathVariable("quesId") Long quesId){

            this.questionService.deleteQuestion(quesId);
        }

    }
