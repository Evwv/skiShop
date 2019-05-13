package com.skiShopNN.repository;

import com.skiShopNN.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList,Integer> {
}
