
package com.skiShopNN.controllers;

import com.skiShopNN.comparators.CustomersComparator;
import com.skiShopNN.model.Customer;
import com.skiShopNN.model.Reservation;
import com.skiShopNN.repository.CustomerRepository;
import com.skiShopNN.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/customers")
    public String customers(Map<String,Object> model) {
        CustomersComparator customersComparator = new CustomersComparator();
        List<Customer> customers = customerRepository.findAll();
        customers.sort(customersComparator);
        model.put("customers",customers);
        return"customers";
    }

    @PostMapping("/customers")
    public String addCustomers(@RequestParam String name, @RequestParam String surname,
                               @RequestParam String phone, Map<String,Object> model) {
        Customer customer = new Customer(name,surname,phone);
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @PostMapping("/customersUpdates")
    public String updateCustomers(@RequestParam String name, @RequestParam String surname, @RequestParam String phone, @RequestParam Integer id, Map<String,Object> model) {
        Customer customer = customerRepository.findById(id).get();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setPhone(phone);
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @RequestMapping(value="customers/delete/{id}", method= RequestMethod.GET)
    public String delete(@PathVariable Integer id, Map<String,Object> model) {
        List<Reservation> reservations = reservationRepository.findAll();
        if (reservations.iterator().hasNext()) {
            for (Reservation reservation : reservations) {
                if (!(reservation.getCustomer().getId().equals(id))) {
                    customerRepository.deleteById(id);
                }
            }
        } else {
            customerRepository.deleteById(id);
        }
        return "redirect:/customers";
    }

    @RequestMapping(value="customersUpdates/{id}", method= RequestMethod.POST)
    public String update(@PathVariable Integer id, @RequestParam String name,
                         @RequestParam String surname, @RequestParam String phone, Map<String,Object> model) {
        Customer customer = customerRepository.findById(id).get();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setPhone(phone);
        customerRepository.save(customer);
        Iterable<Customer> customers = customerRepository.findAll();
        model.put("customers",customers);
        return "redirect:/customers";
    }
}

