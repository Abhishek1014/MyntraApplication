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

/*
 * This CategoryService interface gives the list of all the service that exist in the category service implementation class.
 * Controller class will be calling the service methods by this interface.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    public CategoryEntity getCategoryById(String categoryId) throws CategoryNotFoundException
    {
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

    public List<CategoryEntity> getAllCategoriesOrderedByName()
    {
        return categoryDao.getAllCategoriesOrderedByName();
    }
    public List<CategoryEntity> getCategoriesByBrand(String brandId)
    {
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

