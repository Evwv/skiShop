package com.skiShopNN.controllers;

import com.skiShopNN.model.Customer;
import com.skiShopNN.model.Reservation;
import com.skiShopNN.model.Ski;
import com.skiShopNN.repository.CustomerRepository;
import com.skiShopNN.repository.ReservationRepository;
import com.skiShopNN.repository.SkiRepository;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SkiRepository skiRepository;


    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/reservations")
    public String reservations(Map<String,Object> model) {
        Iterable<Ski> skis = skiRepository.findAll();
        Iterable<Customer> customers = customerRepository.findAll();
        Iterable<Reservation> reservations = reservationRepository.findAll();

        model.put("skis",skis);
        model.put("customers",customers);
        model.put("reservations",reservations);

        return "reservations";
    }

    @PostMapping("/reservations")
    public String addReservations(@RequestParam Customer customers, @RequestParam Ski skis,
                                  @RequestParam String startDate, @RequestParam String finalDate,
                                  @RequestParam String count, Map<String,Object> model) {
        Reservation reservation = new Reservation(customers,skis,startDate,finalDate,count);
        reservationRepository.save(reservation);
        Iterable<Reservation> reservations = reservationRepository.findAll();
        model.put("reservations",reservations);

        return "redirect:/reservations";
    }


}
