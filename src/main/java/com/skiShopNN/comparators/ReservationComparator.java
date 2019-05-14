package com.skiShopNN.comparators;

import com.skiShopNN.model.Reservation;

import java.util.Comparator;

public class ReservationComparator implements Comparator<Reservation> {
    @Override
    public int compare(Reservation reservation1, Reservation reservation2) {
        return reservation1.getId().compareTo(reservation2.getId());
    }
}
