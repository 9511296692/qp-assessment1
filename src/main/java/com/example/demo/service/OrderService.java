package com.example.demo.service;

import java.util.List;

import com.example.demo.model.GroceryItem;
import com.example.demo.model.Order;

public interface OrderService {
    //Order createOrder(List<GroceryItem> items);

	Order createOrder(List<GroceryItem> items);
}