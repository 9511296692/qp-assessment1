package com.example.demo.repo;

import java.util.List;

import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GroceryItem1;
import com.example.demo.model.GroceryItem;

@Repository
public interface GroceryItem1Repository extends JpaRepository<GroceryItem1, Long> {

	List<GroceryItem1> findByQuantityGreaterThan(int i);
	
	
//	List<GroceryItem1> findByQuantityGreaterThan(int i);
//
//	GroceryItem1 save(GroceryItem newItem);

}
