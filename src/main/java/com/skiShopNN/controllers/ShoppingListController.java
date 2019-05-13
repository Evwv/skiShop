package com.skiShopNN.controllers;

import com.skiShopNN.model.Customer;
import com.skiShopNN.model.Reservation;
import com.skiShopNN.model.ShoppingList;
import com.skiShopNN.model.Ski;
import com.skiShopNN.repository.CustomerRepository;
import com.skiShopNN.repository.ShoppingListRepository;
import com.skiShopNN.repository.SkiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ShoppingListController {
    @Autowired
    private SkiRepository skiRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @GetMapping("/shoppingLists")
    public String shoppingLists(Map<String,Object> model) {
        Iterable<Ski> skis = skiRepository.findAll();
        Iterable<Customer> customers = customerRepository.findAll();
        Iterable<ShoppingList> shoppingLists = shoppingListRepository.findAll();

        model.put("skis",skis);
        model.put("customers",customers);
        model.put("shoppingLists",shoppingLists);

        return "shoppingLists";
    }

    @PostMapping("/shoppingLists")
    public String addShoppingLists(@RequestParam Customer customers, @RequestParam Ski skis,
                                  @RequestParam Integer count, @RequestParam String purchaseDay,
                                   @RequestParam Integer totalPrice, Map<String,Object> model) {
        ShoppingList shoppingList = new ShoppingList(customers,skis,count,purchaseDay,totalPrice);
        shoppingListRepository.save(shoppingList);
        Iterable<ShoppingList> shoppingLists = shoppingListRepository.findAll();
        model.put("shoppingLists",shoppingLists);

        return "redirect:/shoppingLists";
    }
}
