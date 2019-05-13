
package com.skiShopNN.controllers;

import com.skiShopNN.model.Customer;
import com.skiShopNN.model.Reservation;
import com.skiShopNN.repository.CustomerRepository;
import com.skiShopNN.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/customers")
    public String customers(Map<String,Object> model) {
        Iterable<Customer> customers = customerRepository.findAll();
        model.put("customers",customers);
        return"customers";
    }

    @PostMapping("/customers")
    public String addCustomers(@RequestParam String name, @RequestParam String surname,
                               @RequestParam String phone, Map<String,Object> model) {
        Customer customer = new Customer(name,surname,phone);
        customerRepository.save(customer);
        Iterable<Customer> customers = customerRepository.findAll();
        model.put("customers",customers);
        return "customers";
    }

    @RequestMapping(value="customers/delete/{id}", method= RequestMethod.GET)
    public String delete(@PathVariable Integer id) {
        Iterable<Reservation> reservations = reservationRepository.findAll();
        if (reservations.iterator().hasNext()) {
            for (Reservation reservation : reservations) {
                if (!(reservation.getCustomer().getId().equals(id))) {
                    customerRepository.deleteById(id);
                }/* else {
                    customerRepository.deleteById(id);
                    reservationRepository.delete(reservation);
                }*/
            }
        } else {
            customerRepository.deleteById(id);
        }
        return "redirect:/customers";
    }
}

