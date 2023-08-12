package com.devops.musicalinstruments.services;

import com.devops.musicalinstruments.model.Category;
import com.devops.musicalinstruments.model.Instrument;

import java.util.List;
import java.util.Optional;

public interface CRUDCategoryService {
    void addCategory(Category category);
    Optional<Category> getCategoryById(Long id);
    List<Category> getAllCategories();
    List<Instrument> getInstrumentsByCategoryId(Long categoryId);
    Boolean updateCategory(Category category);
}
