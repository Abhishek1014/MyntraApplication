package com.upgrad.myntra.service.dao;




import com.upgrad.myntra.service.entity.BrandEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/*
 * This BrandDao interface gives the list of all the dao methods that exist in the brand dao implementation class.
 * Service class will be calling the dao methods by this interface.
 */
@Repository
public class BrandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BrandEntity brandByUUID(String brandId)
    {
        try {
            return entityManager.createNamedQuery("brandsByUUID", BrandEntity.class).setParameter("uuid", brandId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    public List<BrandEntity> brandByName(String brandName)
    {
        return entityManager.createNamedQuery("brandsByName", BrandEntity.class).
                setParameter("brandName", brandName).getResultList();
    }
    public List<BrandEntity> brandByRating()
    {
        return entityManager.createNamedQuery("brandsByRating", BrandEntity.class).getResultList();
    }
    public List<BrandEntity> brandByCategory(String categoryId)
    {
        return entityManager.createNamedQuery("brandsByCategory", BrandEntity.class).
                setParameter("uuid", categoryId).getResultList();
    }
}
