package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.GroceryItem1;
import com.example.demo.ser.GroceryItemService1;

@RestController
@RequestMapping("/api/user/grocery-items")
@CrossOrigin 
public class UserController {
    @Autowired
    private GroceryItemService1 groceryItemService1;
    @GetMapping
    public ResponseEntity<List<GroceryItem1>> viewAvailableGroceryItems() {
        List<GroceryItem1> availableItems = groceryItemService1.viewAvailableGroceryItems();
        return ResponseEntity.ok(availableItems);
    }

    @GetMapping("/grocery-items")
    public ResponseEntity<List<GroceryItem1>> getAllGroceryItems() {
        List<GroceryItem1> groceryItems = groceryItemService1.getAllGroceryItems();
        return new ResponseEntity<>(groceryItems, HttpStatus.OK);
    }
}
