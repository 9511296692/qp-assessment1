package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.GroceryItem;
import com.example.demo.repository.GroceryItemRepository;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {

	
	@Autowired
    private GroceryItemRepository groceryItemRepository;

	
	
	@Override
	public GroceryItem saveGroceryItem(GroceryItem groceryItem) {
		
		   return groceryItemRepository.save(groceryItem);
	}

}
