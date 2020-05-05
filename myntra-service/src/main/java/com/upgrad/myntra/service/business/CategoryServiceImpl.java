package com.upgrad.myntra.service.business;


import com.upgrad.myntra.service.dao.CategoryDao;
import com.upgrad.myntra.service.entity.BrandCategoryEntity;
import com.upgrad.myntra.service.entity.CategoryEntity;
import com.upgrad.myntra.service.exception.CategoryNotFoundException;
import com.upgrad.myntra.service.util.MyntraUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    /**
     * The method implements the business logic for getting category by its id endpoint.
     */
    @Override
    public CategoryEntity getCategoryById(String categoryId) throws CategoryNotFoundException {

        if (MyntraUtil.isInValid(categoryId)) {
            throw new CategoryNotFoundException("CNF-001", "Category id field should not be empty");
        }
        CategoryEntity category = categoryDao.getCategoryById(categoryId);
        // No match found in the Database for the uuid
        if (category == null) {
            throw new CategoryNotFoundException("CNF-002", "No category by this id");
        }
        return category;
    }

    /**
     * The method implements the business logic for getting all categories ordered by their name endpoint.
     */
    @Override
    public List<CategoryEntity> getAllCategoriesOrderedByName()  {

        return categoryDao.getAllCategoriesOrderedByName();
    }

    /**
     * The method implements the business logic for getting categories for any particular brand.
     */
    @Override
    public List<CategoryEntity> getCategoriesByBrand(String brandId)  {
        List<BrandCategoryEntity> brandCategories = categoryDao.getBrandCategoriesByBrandUUID(brandId);
        List<CategoryEntity> categories = new ArrayList<CategoryEntity>();
        if (brandCategories != null) {
            brandCategories.forEach(brandCategory -> {
                categories.add(brandCategory.getCategory());
            });
        }
        return categories;
    }
}
