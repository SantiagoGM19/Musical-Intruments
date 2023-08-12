package com.devops.musicalinstruments.controllers;

import com.devops.musicalinstruments.model.Category;
import com.devops.musicalinstruments.model.Instrument;
import com.devops.musicalinstruments.services.CRUDCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "api/v1/category")
public class CategoryController {

    private final CRUDCategoryService crudCategoryService;

    public CategoryController(CRUDCategoryService crudCategoryService){
        this.crudCategoryService = crudCategoryService;
    }

    @PostMapping
    public void addCategory(@RequestBody Category category){
        crudCategoryService.addCategory(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Long id){
        try{
            Optional<Category> categoryFound = crudCategoryService.getCategoryById(id);
            if(categoryFound.isEmpty()){
                return new ResponseEntity<>(categoryFound, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(categoryFound, HttpStatus.FOUND);
        }catch (Exception exception){
            return new ResponseEntity<>(Optional.empty(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        try {
            List<Category> categoriesFetched = crudCategoryService.getAllCategories();
            return new ResponseEntity<>(categoriesFetched, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(List.of(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/instruments/{id}")
    public ResponseEntity<List<Instrument>> getInstrumentsByCategoryId(@PathVariable Long categoryId){
        try{
            List<Instrument> instrumentsFetched = crudCategoryService.getInstrumentsByCategoryId(categoryId);
            return new ResponseEntity<>(instrumentsFetched, HttpStatus.FOUND);
        }catch (Exception exception){
            return new ResponseEntity<>(List.of(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<String> updateCategory(@RequestBody Category category){
        try{
            Boolean categoryUpdated = crudCategoryService.updateCategory(category);
            if(!categoryUpdated){
                return new ResponseEntity<>("Category does not exist on the DB, so it can not being updated", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Category updated!", HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
