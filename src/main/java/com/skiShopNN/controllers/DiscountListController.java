package com.skiShopNN.controllers;

import com.skiShopNN.comparators.CompaniesComparator;
import com.skiShopNN.comparators.DiscountListComparator;
import com.skiShopNN.model.Company;
import com.skiShopNN.model.DiscountList;
import com.skiShopNN.repository.CompanyRepository;
import com.skiShopNN.repository.DiscountListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class DiscountListController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DiscountListRepository discountListRepository;

    @GetMapping("/discountLists")
    public String discountLists(Map<String,Object> model) {
        List<DiscountList> discountLists = discountListRepository.findAll();
        DiscountListComparator discountListComparator = new DiscountListComparator();
        discountLists.sort(discountListComparator);
        model.put("discountLists",discountLists);
        List<Company> companies = companyRepository.findAll();
        model.put("companies",companies);
        return "discountLists";
    }

    @PostMapping("/discountLists")
    public String addDiscountList(@RequestParam Company company, @RequestParam String startDate, @RequestParam String finalDate, @RequestParam String discount, Map<String,Object> model) {
        DiscountList discountList = new DiscountList(company,startDate,finalDate,discount);
        discountListRepository.save(discountList);
        return "redirect:/discountLists";
    }

    @PostMapping("/discountListsUpdate")
    public String updateDiscountList(@RequestParam Company company, @RequestParam String startDate,
                                     @RequestParam String finalDate, @RequestParam String discount,
                                     @RequestParam Integer id, Map<String,Object> model) {
        DiscountList discountList = discountListRepository.findById(id).get();
        discountList.setCompany(company);
        discountList.setStartDate(startDate);
        discountList.setFinalDate(finalDate);
        discountList.setDiscount(discount);
        discountListRepository.save(discountList);
        return "redirect:/discountLists";
    }

    @RequestMapping(value="discountLists/delete/{id}", method= RequestMethod.GET)
    public String deleteDiscountList(@PathVariable Integer id,Map<String,Object> model) {
        discountListRepository.deleteById(id);
        return "redirect:/discountLists";
    }
}
