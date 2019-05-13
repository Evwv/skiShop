package com.skiShopNN.controllers;

import com.skiShopNN.model.Company;
import com.skiShopNN.model.DiscountList;
import com.skiShopNN.repository.CompanyRepository;
import com.skiShopNN.repository.DiscountListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class DiscountListController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DiscountListRepository discountListRepository;

    @GetMapping("/discountLists")
    public String discountLists(Map<String,Object> model) {
        Iterable<DiscountList> discountLists = discountListRepository.findAll();
        Iterable<Company> companies = companyRepository.findAll();
        model.put("discountLists",discountLists);
        model.put("companies",companies);
        return "discountLists";
    }

    @PostMapping("/discountLists")
    public String addDiscountList(@RequestParam Company company, @RequestParam String startDate, @RequestParam String finalDate, @RequestParam String discount, Map<String,Object> model) {
        DiscountList discountList = new DiscountList(company,startDate,finalDate,discount);
        discountListRepository.save(discountList);
        Iterable<DiscountList> discountLists = discountListRepository.findAll();
        model.put("discountLists",discountLists);
        return "redirect:/discountLists";
    }

    @RequestMapping(value="discountLists/delete/{id}", method= RequestMethod.GET)
    public String deleteDiscountList(@PathVariable Integer id,Map<String,Object> model) {
        discountListRepository.deleteById(id);
        Iterable<DiscountList> discountLists = discountListRepository.findAll();
        model.put("discountLists",discountLists);
        return "redirect:/discountLists";
    }
}
