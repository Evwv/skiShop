package com.skiShopNN.comparators;

import com.skiShopNN.model.ShoppingList;

import java.util.Comparator;

public class ShoppingListComparator implements Comparator<ShoppingList> {
    @Override
    public int compare(ShoppingList shoppingList1, ShoppingList shoppingList2) {
        return shoppingList1.getId().compareTo(shoppingList2.getId());
    }
}
