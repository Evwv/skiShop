package com.skiShopNN.controllers;

import com.skiShopNN.comparators.ReservationComparator;
import com.skiShopNN.comparators.SkiComparator;
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

import java.util.List;
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
        List<Ski> skis = skiRepository.findAll();
        List<Customer> customers = customerRepository.findAll();
        List<Reservation> reservations = reservationRepository.findAll();
        ReservationComparator reservationComparator = new ReservationComparator();
        reservations.sort(reservationComparator);
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
        List<Reservation> reservations = reservationRepository.findAll();
        model.put("reservations",reservations);

        return "redirect:/reservations";
    }

    @PostMapping("/reservationsUpdates")
    public String update(@RequestParam Customer customer, @RequestParam Ski ski,
                         @RequestParam String startDate, @RequestParam String finalDate,
                         @RequestParam String count, @RequestParam Integer id, Map<String,Object> model) {
        Reservation reservation = reservationRepository.findById(id).get();
        reservation.setCustomer(customer);
        reservation.setSki(ski);
        reservation.setStartDate(startDate);
        reservation.setFinalDate(finalDate);
        reservation.setCount(count);
        reservationRepository.save(reservation);
        return "redirect:/reservations";
    }

    @RequestMapping(value = "reservations/delete/{id}",method = RequestMethod.GET)
    public String deleteItem(@PathVariable Integer id, Map<String,Object> model) {
        reservationRepository.deleteById(id);
        return "redirect:/reservations";
    }


}
