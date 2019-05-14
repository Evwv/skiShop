package com.skiShopNN.controllers;

import com.skiShopNN.comparators.CompaniesComparator;
import com.skiShopNN.model.Company;
import com.skiShopNN.model.DiscountList;
import com.skiShopNN.repository.CompanyRepository;
import com.skiShopNN.repository.DiscountListRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DiscountListRepository discountListRepository;

    @GetMapping("/companies")
    public String companies(Map<String, Object> model) {
        List<Company> companies = companyRepository.findAll();
        CompaniesComparator companiesComparator = new CompaniesComparator();
        companies.sort(companiesComparator);
        model.put("companies",companies);
        return "companies";
    }

    @PostMapping("/companies")
    public String addCompany(@RequestParam String companyName, @RequestParam String country,
                             @RequestParam String numberOfEmployees, @RequestParam String address, @RequestParam String phone, Map<String, Object> model) {
        Company company = new Company(companyName, country, numberOfEmployees, address, phone);
        companyRepository.save(company);
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
        return "redirect:/companies";
    }

    @PostMapping("/companiesUpdates")
    public String updateCompany(@RequestParam String companyName, @RequestParam String country,
                                @RequestParam String numberOfEmployees, @RequestParam String address, @RequestParam String phone, @RequestParam Integer id, Map<String, Object> model) {
        Company company = companyRepository.findById(id).get();
        company.setCompanyName(companyName);
        company.setCountry(country);
        company.setNumberOfEmployees(numberOfEmployees);
        company.setAddress(address);
        company.setPhone(phone);
        companyRepository.save(company);
        return "redirect:/companies";
    }
}
