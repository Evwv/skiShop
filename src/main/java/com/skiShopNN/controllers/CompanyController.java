package com.skiShopNN.controllers;

import com.skiShopNN.model.Company;
import com.skiShopNN.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/companies")
    public String companies(Map<String,Object> model) {
        Iterable<Company> companies = companyRepository.findAll();
        model.put("companies",companies);
        return "companies";
    }

    @PostMapping("/companies")
    public String addCompany(@RequestParam String companyName, @RequestParam String country,
                             @RequestParam String numberOfEmployees, @RequestParam String address, @RequestParam String phone, Map<String,Object> model) {
        Company company = new Company(companyName,country,numberOfEmployees,address,phone);
        companyRepository.save(company);
        Iterable<Company> companies = companyRepository.findAll();
        model.put("companies",companies);
        return "companies";
    }
}
