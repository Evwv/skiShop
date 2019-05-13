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
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DiscountListRepository discountListRepository;

    @GetMapping("/companies")
    public String companies(Map<String, Object> model) {
        Iterable<Company> companies = companyRepository.findAll();
        model.put("companies", companies);
        return "companies";
    }

    @PostMapping("/companies")
    public String addCompany(@RequestParam String companyName, @RequestParam String country,
                             @RequestParam String numberOfEmployees, @RequestParam String address, @RequestParam String phone, Map<String, Object> model) {
        Company company = new Company(companyName, country, numberOfEmployees, address, phone);
        companyRepository.save(company);
        Iterable<Company> companies = companyRepository.findAll();
        model.put("companies", companies);
        return "redirect:/companies";
    }

    @RequestMapping(value = "companies/delete/{id}", method = RequestMethod.GET)
    public String deleteCompany(@PathVariable Integer id, Map<String, Object> model) {
        Iterable<DiscountList> discountLists = discountListRepository.findAll();
        if (discountLists.iterator().hasNext()) {
            for (DiscountList discountList : discountLists) {
                if (!(discountList.getCompany().getId().equals(id))) {
                    companyRepository.deleteById(id);
                }
            }
        } else {
            companyRepository.deleteById(id);
        }
        Iterable<Company> companies = companyRepository.findAll();
        model.put("companies", companies);
        return "redirect:/companies";
    }
}
