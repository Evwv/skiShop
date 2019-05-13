package com.skiShopNN.repository;

import com.skiShopNN.model.Ski;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkiRepository extends JpaRepository<Ski,Integer> {
}
