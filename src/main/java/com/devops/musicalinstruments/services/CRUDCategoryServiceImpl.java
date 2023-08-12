package com.devops.musicalinstruments.services;

import com.devops.musicalinstruments.model.Category;
import com.devops.musicalinstruments.model.Instrument;
import com.devops.musicalinstruments.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CRUDCategoryServiceImpl implements CRUDCategoryService{

    private final CategoryRepository categoryRepository;

    public CRUDCategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Instrument> getInstrumentsByCategoryId(Long categoryId) {
        return categoryRepository.findInstrumentsByCategoryId(categoryId);
    }

    @Override
    public Boolean updateCategory(Category category) {
        Boolean categoryUpdated = false;
        if(categoryRepository.existsById(category.getId())){
            categoryRepository.save(category);
            categoryUpdated = true;
        }
        return categoryUpdated;
    }
}
