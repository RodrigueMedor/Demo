package mum.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.domain.Category;
 import mum.edu.domain.ISBNumber;
import mum.edu.repository.ApplicationRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private ApplicationRepository applicationRepository;

     public CategoryServiceImpl() {
     }

    public List<Category> getAllCategories() {
        return applicationRepository.getCategories();
    }
    
    public Category getCategory(int id) {
        for (Category category : applicationRepository.getCategories()) {
            if (id == category.getId()) {
                return category;
            }
        }
        return null;
    }

    public Category getCategoryByName(String name) {
        for (Category category : applicationRepository.getCategories()) {
            if (name.equals( category.getName()) ) {
                return category;
            }
        }
        return null;
    }

     public Category save(Category category) {
    	 category.setId(getNextId());
    	 applicationRepository.getCategories().add(category);
        return category;
    }

     
    public Category update(Category category) {
        int categoryCount = applicationRepository.getCategories().size();
        for (int i = 0; i < categoryCount; i++) {
            Category savedCategory = applicationRepository.getCategories().get(i);
            if (savedCategory.getId() == category.getId()) {
            	applicationRepository.getCategories().set(i, category);
                return category;
            }
        }
        return category;
    }
    

    public int getNextId() {
        int id = 0;
        for (Category category : applicationRepository.getCategories()) {
            int categoryId = category.getId();
            if (categoryId > id) {
                id = categoryId;
            }
        }
        return id + 1;
    }
}
