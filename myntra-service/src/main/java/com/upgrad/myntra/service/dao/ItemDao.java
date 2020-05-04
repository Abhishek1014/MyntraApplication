package com.upgrad.myntra.service.dao;

import com.upgrad.myntra.service.entity.ItemEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/*
 * This ItemDao interface gives the list of all the dao methods that exist in the item dao implementation class.
 * Service class will be calling the dao methods by this interface.
 */
@Repository
public class ItemDao {
    @PersistenceContext
    private EntityManager entityManager;

    public ItemEntity getItemsByBrand(String brandId)
    {
        try {
            return entityManager.createNamedQuery("ItemsByBrand", ItemEntity.class).setParameter("brandId", brandId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public List<ItemEntity> getItemsByCategory(String categoryId)
    {
        return entityManager.createNamedQuery("ItemsByCategory", ItemEntity.class).setParameter("categoryId", categoryId).getResultList();

    }
}
