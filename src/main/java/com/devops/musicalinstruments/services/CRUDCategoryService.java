package com.devops.musicalinstruments.services;

import com.devops.musicalinstruments.model.Category;
import com.devops.musicalinstruments.model.Instrument;

import java.util.List;

public interface CRUDCategoryService {
    void addCategory(Category category);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    List<Instrument> getInstrumentsByCategoryId(Long categoryId);
    void updateCategory(Category category);
    void deleteCategory(Long id);
}
