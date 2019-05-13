package com.skiShopNN.repository;

import com.skiShopNN.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

}
