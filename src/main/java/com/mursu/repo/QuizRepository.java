package com.mursu.repo;

import com.mursu.model.exam.Category;
import com.mursu.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository  extends JpaRepository<Quiz,Long> {

    public List<Quiz> findBycategory(Category category);
    
    public List<Quiz> findByActive(Boolean b);
    public List<Quiz> findByCategoryAndActive(Category c, Boolean b);
}
