package com.example.demo.ser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GroceryItem1;
import com.example.demo.entity.InventoryManagementRequest;
import com.example.demo.model.GroceryItem;
//import com.example.demo.model.InventoryManagementRequest;
import com.example.demo.repo.GroceryItem1Repository;
import com.example.demo.repository.GroceryItemRepository;


@Service
public class GroceryItemService1 {
	
	
	
	
	  @Autowired
	    private GroceryItem1Repository groceryItem1Repository;

	  
	    public GroceryItem1 addNewGroceryItem(GroceryItem1 newItem) {
	        return groceryItem1Repository.save(newItem);
	    }
	    
	    
	    public List<GroceryItem1> viewExistingGroceryItems() {
	        return groceryItem1Repository.findAll();
	    }
	    
	    
	    public boolean removeGroceryItem(Long itemId) {
	        if (groceryItem1Repository.existsById(itemId)) {
	        	groceryItem1Repository.deleteById(itemId);
	            return true;
	        }
	        return false;
	    }

	    public GroceryItem1 updateGroceryItem(Long itemId, GroceryItem1 updatedItemDetails) {
	        if (groceryItem1Repository.existsById(itemId)) {
	            GroceryItem1 existingItem = groceryItem1Repository.findById(itemId).get();

	            existingItem.setName(updatedItemDetails.getName());
	            existingItem.setPrice(updatedItemDetails.getPrice());
	            existingItem.setQuantity(updatedItemDetails.getQuantity());


	            return groceryItem1Repository.save(existingItem);
	        }
	        return null;
	    }
	    

	    public GroceryItem1 manageInventory(Long itemId, InventoryManagementRequest inventoryRequest) {
	        if (groceryItem1Repository.existsById(itemId)) {
	            GroceryItem1 existingItem = groceryItem1Repository.findById(itemId).get();

	            if ("increase".equalsIgnoreCase(inventoryRequest.getAction())) {
	                existingItem.setQuantity(existingItem.getQuantity() + inventoryRequest.getQuantity());
	            } else if ("decrease".equalsIgnoreCase(inventoryRequest.getAction())) {
	                int newQuantity = existingItem.getQuantity() - inventoryRequest.getQuantity();
	                if (newQuantity >= 0) {
	                    existingItem.setQuantity(newQuantity);
	                } else {
	                    return null;
	                }
	            } else {
	                return null;
	            }

	            return groceryItem1Repository.save(existingItem);
	        }
	        return null;
	    }
	    
	    
	    public List<GroceryItem1> viewAvailableGroceryItems() {
	        return groceryItem1Repository.findByQuantityGreaterThan(0);
	    }

	    
	    public List<GroceryItem1> getAllGroceryItems() {
	        return groceryItem1Repository.findAll();
	    }



	
	


}
