package com.skiShopNN.comparators;

import com.skiShopNN.model.Company;

import java.util.Comparator;

public class CompaniesComparator implements Comparator<Company> {
    @Override
    public int compare(Company company1, Company company2) {
        return company1.getId().compareTo(company2.getId());
    }
}
