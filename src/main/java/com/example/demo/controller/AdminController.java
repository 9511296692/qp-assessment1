package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.GroceryItem1;
import com.example.demo.entity.InventoryManagementRequest;
import com.example.demo.ser.GroceryItemService1;



@RestController
@RequestMapping("/api/admin/grocery-items")
@CrossOrigin     
public class AdminController {
	
	
	  @Autowired
	    private GroceryItemService1 groceryItemService1;

	    @PostMapping("/add")
	    public ResponseEntity<GroceryItem1> addNewGroceryItem(@RequestBody GroceryItem1 newItem) {
	        GroceryItem1 addedItem = groceryItemService1.addNewGroceryItem(newItem);
	        return new ResponseEntity<>(addedItem, HttpStatus.CREATED);
	    }
	    
	    @GetMapping
	    public ResponseEntity<List<GroceryItem1>> viewExistingGroceryItems() {
	        List<GroceryItem1> existingItems = groceryItemService1.viewExistingGroceryItems();
	        return ResponseEntity.ok(existingItems);
	    }

	    @DeleteMapping("/{itemId}")
	    public ResponseEntity<String> removeGroceryItem(@PathVariable Long itemId) {
	        boolean removed = groceryItemService1.removeGroceryItem(itemId);

	        if (removed) {
	            return ResponseEntity.ok("Grocery item removed successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grocery item not found");
	        }
	    }
	    
	    
	    @PutMapping("/{itemId}")
	    public ResponseEntity<GroceryItem1> updateGroceryItemDetails(
	            @PathVariable Long itemId,
	            @RequestBody GroceryItem1 updatedItemDetails
	    ) {
	        GroceryItem1 updatedItem = groceryItemService1.updateGroceryItem(itemId, updatedItemDetails);

	        if (updatedItem != null) {
	            return ResponseEntity.ok(updatedItem);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	    }
	    
	    @PatchMapping("/{itemId}/manage-inventory")
	    public ResponseEntity<GroceryItem1> manageInventory(
	            @PathVariable Long itemId,
	            @RequestBody InventoryManagementRequest inventoryRequest) {
	        GroceryItem1 updatedItem = groceryItemService1.manageInventory(itemId, inventoryRequest);

	        if (updatedItem != null) {
	            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	    
	    
	    

}
