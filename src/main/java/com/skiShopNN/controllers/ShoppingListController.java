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
import org.springframework.web.bind.annotation.*;

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
                                  @RequestParam Integer count, @RequestParam String purchaseDay, Map<String,Object> model) {
        ShoppingList shoppingList = new ShoppingList(customers,skis,count,purchaseDay);
        shoppingListRepository.save(shoppingList);
        Iterable<ShoppingList> shoppingLists = shoppingListRepository.findAll();
        model.put("shoppingLists",shoppingLists);

        return "redirect:/shoppingLists";
    }

    @RequestMapping(value = "shoppingLists/delete/{id}",method = RequestMethod.GET)
    public String deleteItem(@PathVariable Integer id, Map<String,Object> model) {
        shoppingListRepository.deleteById(id);
        Iterable<ShoppingList> shoppingLists = shoppingListRepository.findAll();
        model.put("shoppingLists",shoppingLists);
        return "redirect:/shoppingLists";
    }
}
