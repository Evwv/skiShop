package com.skiShopNN.comparators;

import com.skiShopNN.model.DiscountList;

import java.util.Comparator;

public class DiscountListComparator implements Comparator<DiscountList> {
    @Override
    public int compare(DiscountList discountList1, DiscountList discountList2) {
        return discountList1.getId().compareTo(discountList2.getId());
    }
}
