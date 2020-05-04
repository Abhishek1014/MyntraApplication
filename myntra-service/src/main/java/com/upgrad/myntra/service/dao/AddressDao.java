package com.upgrad.myntra.service.dao;





import com.upgrad.myntra.service.entity.AddressEntity;
import com.upgrad.myntra.service.entity.CustomerAddressEntity;
import com.upgrad.myntra.service.entity.CustomerEntity;
import com.upgrad.myntra.service.entity.StateEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/*
 * This AddressDao interface gives the list of all the dao methods that exist in the address dao implementation class.
 * Service class will be calling the dao methods by this interface.
 */
@Repository
public class AddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    public AddressEntity saveAddress(AddressEntity addressEntity)
    {
        entityManager.persist(addressEntity);
        return addressEntity;
    }

    public AddressEntity getAddressByUUID(String addressId)
    {
        try {
            return entityManager.createNamedQuery("getAddressByUUID", AddressEntity.class).setParameter("uuid", addressId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    public CustomerAddressEntity getCustomerByAddress(String addressId)
    {
        try {
            return entityManager.createNamedQuery("userByAddress", CustomerAddressEntity.class).setParameter("uuid", addressId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    public CustomerAddressEntity saveCustomerAddress(CustomerAddressEntity customerAddressEntity)
    {
        entityManager.persist(customerAddressEntity);
        return customerAddressEntity;
    }

    public AddressEntity deleteAddress(AddressEntity addressEntity)
    {
        entityManager.remove(addressEntity);
        return addressEntity;
    }

    public List<AddressEntity> getAllAddress(CustomerEntity customer)
    {
        return entityManager.createNamedQuery("getAllAddress", AddressEntity.class).setParameter("customer",customer.getId()).getResultList();
    }

    public StateEntity getStateByUUID(String uuid)
    {
        try {
            return entityManager.createNamedQuery("getStateByUUID", StateEntity.class)
                    .setParameter("uuid", uuid).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
