package com.devops.musicalinstruments.repositories;

import com.devops.musicalinstruments.model.Category;
import com.devops.musicalinstruments.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT * FROM instruments WHERE category_id=?1")
    List<Instrument> findInstrumentsByCategoryId(Long categoryId);
}
