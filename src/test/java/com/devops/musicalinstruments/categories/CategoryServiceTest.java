package com.devops.musicalinstruments.categories;

import com.devops.musicalinstruments.model.Category;
import com.devops.musicalinstruments.repositories.CategoryRepository;
import com.devops.musicalinstruments.services.CRUDCategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CRUDCategoryServiceImpl crudCategoryService;

    @Test
    public void givenACategoryId_whenGetCategoryById_shouldAReturnTheCategory(){
        //arrange
        Category categoryExpected = new Category(1L,"Cuerdas", List.of());
        Mockito.when(categoryRepository.findById(1L)).thenReturn(Optional.of(categoryExpected));

        //act
        Optional<Category> categoryFetched = crudCategoryService.getCategoryById(1L);

        //assert
        Assertions.assertEquals(categoryExpected, categoryFetched.get());
    }

    @Test
    public void givenClientNeedAllCategories_whenGetAllCategories_shouldReturnAListOfAllCategories(){
        //arrange
        Category category1 = new Category(1L, "Cuerdas", List.of());
        Category category2 = new Category(1L, "Percusion", List.of());
        Category category3 = new Category(1L, "Teclas", List.of());
        Category category4 = new Category(1L, "Viento", List.of());
        int expectedNumberOfCategories = 2;
        List<Category> categoriesExpected = List.of(category1,category2,category3,category4);
        Mockito.when(categoryRepository.findAll()).thenReturn(categoriesExpected);

        //act
        List<Category> categoriesFetched = crudCategoryService.getAllCategories();

        //assert
        Assertions.assertEquals(categoriesExpected, categoriesFetched);
        Assertions.assertEquals(expectedNumberOfCategories, categoriesFetched.size());
    }
}
