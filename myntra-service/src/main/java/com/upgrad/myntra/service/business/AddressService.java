package com.upgrad.myntra.service.business;





import com.upgrad.myntra.service.dao.AddressDao;
import com.upgrad.myntra.service.entity.AddressEntity;
import com.upgrad.myntra.service.entity.CustomerAddressEntity;
import com.upgrad.myntra.service.entity.CustomerEntity;
import com.upgrad.myntra.service.entity.StateEntity;
import com.upgrad.myntra.service.exception.AddressNotFoundException;
import com.upgrad.myntra.service.exception.AuthorizationFailedException;
import com.upgrad.myntra.service.exception.SaveAddressException;
import com.upgrad.myntra.service.util.MyntraUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/*
 * This AddressService interface gives the list of all the service that exist in the address service implementation class.
 * Controller class will be calling the service methods by this interface.
 */
@Service
public class AddressService {

    @Autowired
    private AddressDao addressDao;

    public AddressEntity saveAddress(AddressEntity addressEntity, CustomerAddressEntity customerAddressEntity) throws
            SaveAddressException
    {
        if (MyntraUtil.isInValid(addressEntity.getFlatBuilNo()) || MyntraUtil.isInValid(addressEntity.getLocality())
                || MyntraUtil.isInValid(addressEntity.getCity()) || MyntraUtil.isInValid(addressEntity.getPincode()) ||
                addressEntity.getState() == null) {
            throw new SaveAddressException("SAR-001", "No field can be empty");
        }

        // Check if the pin code entered is valid or not
        if (MyntraUtil.isInvalidPinCode(addressEntity.getPincode())) {
            throw new SaveAddressException("SAR-002", "Invalid pincode");
        }
        addressEntity.setUuid(UUID.randomUUID().toString());
        // Address is active by default unless any order is placed
        addressEntity.setActive(1);
        AddressEntity updatedAddress = addressDao.saveAddress(addressEntity);

        return addressEntity;
    }

    public AddressEntity getAddressByUUID(String addressId, CustomerEntity customerEntity) throws AuthorizationFailedException,
            AddressNotFoundException
    {
        if (MyntraUtil.isInValid(addressId)) {
            throw new AddressNotFoundException("ANF-005", "Address id can not be empty");
        }
        AddressEntity address = addressDao.getAddressByUUID(addressId);
        // Check if any address matched with the uuid, otherwise throw error
        if (address == null) {
            throw new AddressNotFoundException("ANF-003", "No address by this id");
        }
        CustomerAddressEntity customerAddressEntity = addressDao.getCustomerByAddress(addressId);
        //if the customer who has logged in is not same as the customer which belongs to the address to be deleted
        if (customerAddressEntity == null || (customerAddressEntity.getCustomer() != null
                && customerAddressEntity.getCustomer().getId() != customerEntity.getId())) {
            throw new AuthorizationFailedException("ATHR-004", "You are not authorized to view/update/delete any one else's address");
        }
        return customerAddressEntity.getAddress();
    }

    public AddressEntity deleteAddress(AddressEntity addressEntity)
    {
        if (addressEntity.getActive() == 1) {
            AddressEntity deletedAddress = addressDao.deleteAddress(addressEntity);
            return deletedAddress;
        } else {
            // active other than 1 say 0 indicates it is linked to an order and archived, so no delete happens
            return addressEntity;
        }
    }

    public List<AddressEntity> getAllAddress(CustomerEntity customer)
    {
        return addressDao.getAllAddress(customer);
    }


    public StateEntity getStateByUUID(String uuid) throws AddressNotFoundException
    {
        StateEntity state = addressDao.getStateByUUID(uuid);
        if (state == null) {
            throw new AddressNotFoundException("ANF-002", "No state by this id");
        }
        return state;
    }
}
