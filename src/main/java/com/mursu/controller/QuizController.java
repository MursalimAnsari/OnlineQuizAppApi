package com.mursu.controller;

import com.mursu.model.exam.Category;
import com.mursu.model.exam.Quiz;
import com.mursu.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

      @Autowired
      private QuizService quizService;
 
      // add quiz...
      @PostMapping("/")
      public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
         return  ResponseEntity.ok(this.quizService.addQuiz(quiz));
     }


      // Update Quiz...
      // remember that we have to send the old quiz id...

       @PutMapping("/")
       public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
        return  ResponseEntity.ok(this.quizService.addQuiz(quiz));
      }


      //get all quizzes...
       @GetMapping("/")
       public ResponseEntity<?> geyQuizzes(){
          return ResponseEntity.ok(this.quizService.getQuizzes());
      }


       // get single quiz...
       // @Path Variable is used to get the url data and send to the api...
       @GetMapping("/{qid}")
       public Quiz getQuiz(@PathVariable("qid") Long qid){

          return  this.quizService.getQuiz(qid);
       }

       // delete quiz in the api...

       @DeleteMapping("/{qid}")
       public  void  deleteQuiz(@PathVariable("qid") Long qid){

           this.quizService.deleteQuiz(qid);

       }

       @GetMapping("/category/{cid}")
      public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid){
          Category category =new Category();
          category.setCid(cid);
            return   this.quizService.getQuizzesOfCategory(category);
       }

       //get active quizzes...
      @GetMapping("/active")
    List<Quiz> getActiveQuizzes(){
          return  this.quizService.getActiveQuizzes();
      }


    //get active quizzes of category...
    @GetMapping("/category/active/{cid}")
    List<Quiz> getActiveQuizzesOfCategory(@PathVariable("cid") Long cid){
       Category category= new Category();
       category.setCid(cid);
        return  this.quizService.getActiveQuizzesOfCategory(category);
    }

}
