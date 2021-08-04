package com.mursu.service.impl;

import com.mursu.model.exam.Category;
import com.mursu.repo.CategoryRepository;
import com.mursu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public Category addCategory(Category category) {
        return  this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {

        // one method to find all categories
        // find all returns List of elements hence we have to typecast it to List...
        return  new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId)
    {
            this.categoryRepository.deleteById(categoryId);
    }
}
