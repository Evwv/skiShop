package com.skiShopNN.comparators;

import com.skiShopNN.model.Ski;

import java.util.Comparator;

public class SkiComparator implements Comparator<Ski> {
    @Override
    public int compare(Ski ski1, Ski ski2) {
        return ski1.getId().compareTo(ski2.getId());
    }
}
