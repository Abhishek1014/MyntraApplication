package com.upgrad.myntra.service.business;



import com.upgrad.myntra.service.dao.CategoryDao;
import com.upgrad.myntra.service.dao.ItemDao;
import com.upgrad.myntra.service.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * This ItemService interface gives the list of all the service that exist in the item service implementation class.
 * Controller class will be calling the service methods by this interface.
 */
@Service
public abstract class ItemService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private CategoryDao categoryDao;




    public List<ItemEntity> getItemsByCategoryAndBrand(String brandId, String categoryId)
    {
        List<ItemEntity> itemsOfbrand = (List<ItemEntity>) itemDao.getItemsByBrand(brandId);
        // Get Items based on category uuid
        List<ItemEntity> categoryItems = itemDao.getItemsByCategory(categoryId);
        List<ItemEntity> categoryItemsOfBrand = new ArrayList<ItemEntity>();
        if (itemsOfbrand != null) {
            itemsOfbrand.forEach(item -> {
                if (categoryItems != null) {
                    for (ItemEntity categoryItem : categoryItems) {
                        // Check if the item belongs to one of the items in this category
                        if (item.getId() == categoryItem.getId()) {
                            categoryItemsOfBrand.add(item);
                            break;
                        }
                    }
                }
            });
        }
        return categoryItemsOfBrand;
    }

    public abstract ItemEntity getItemsByBrand(String brandId);

    public abstract List<ItemEntity> getItemsByCategory(String categoryId);
}
