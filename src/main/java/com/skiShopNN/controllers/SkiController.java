package com.skiShopNN.controllers;

import com.skiShopNN.model.Ski;
import com.skiShopNN.repository.SkiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SkiController {
    @Autowired
    private SkiRepository skiRepository;

    @GetMapping("/skis")
    public String skis(Map<String,Object> model) {
        Iterable<Ski> skis = skiRepository.findAll();
        model.put("skis",skis);
        return "skis";
    }

    @PostMapping("/skis")
    public String addSkis(@RequestParam String name, @RequestParam String firm, @RequestParam String length, @RequestParam Integer price, Map<String,Object> model) {
        Ski ski = new Ski(name,length,firm,price);
        skiRepository.save(ski);
        Iterable<Ski> skis = skiRepository.findAll();
        model.put("skis",skis);
        return "skis";
    }
}
