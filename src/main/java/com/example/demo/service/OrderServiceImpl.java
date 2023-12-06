package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.GroceryItem;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GroceryItemService groceryItemService;
	
	
	
	@Override
	public Order createOrder(List<GroceryItem> items) {
		
		Order order = new Order();
        List<GroceryItem> savedItems = new ArrayList<>();

        for (GroceryItem item : items) {
            savedItems.add(groceryItemService.saveGroceryItem(item));
        }

        order.setItems(savedItems);
        return orderRepository.save(order);
    }
		
	}


