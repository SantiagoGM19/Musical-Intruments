package com.devops.musicalinstruments.services;

import com.devops.musicalinstruments.model.Category;
import com.devops.musicalinstruments.model.Instrument;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDCategoryServiceImpl implements CRUDCategoryService{

    public CRUDCategoryServiceImpl(){

    }

    @Override
    public void addCategory(Category category) {

    }

    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public List<Instrument> getInstrumentsByCategoryId(Long categoryId) {
        return null;
    }

    @Override
    public void updateCategory(Category category) {

    }

    @Override
    public void deleteCategory(Long id) {

    }
}
