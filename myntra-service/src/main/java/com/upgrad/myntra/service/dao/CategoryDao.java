package com.upgrad.myntra.service.dao;



import com.upgrad.myntra.service.entity.BrandCategoryEntity;
import com.upgrad.myntra.service.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/*
 * This CategoryDao interface gives the list of all the dao methods that exist in the category dao implementation class.
 * Service class will be calling the dao methods by this interface.
 */
@Repository
public class CategoryDao {
    @PersistenceContext
    private EntityManager entityManager;

    public CategoryEntity getCategoryById(String categoryId)
    {
        try {
            return entityManager.createNamedQuery("getCategoryById", CategoryEntity.class).setParameter("uuid", categoryId).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<CategoryEntity> getAllCategoriesOrderedByName()
    {
        return entityManager.createNamedQuery("getAllCategoriesOrderedByName", CategoryEntity.class).getResultList();
    }

    public  List<CategoryEntity> getCategoriesByBrand(String brandId)
    {
        return entityManager.createNamedQuery("getCategoriesBybrand", CategoryEntity.class).
                setParameter("uuid", brandId).getResultList();
    }

    public List<BrandCategoryEntity> getBrandCategoriesByBrandUUID(String brandId) {
        return entityManager.createNamedQuery("brandByCategory", BrandCategoryEntity.class).setParameter("uuid", brandId).getResultList();
    }
}

