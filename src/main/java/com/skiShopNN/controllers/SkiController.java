package com.skiShopNN.controllers;

import com.skiShopNN.comparators.SkiComparator;
import com.skiShopNN.model.Reservation;
import com.skiShopNN.model.Ski;
import com.skiShopNN.repository.ReservationRepository;
import com.skiShopNN.repository.SkiRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class SkiController {
    @Autowired
    private SkiRepository skiRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/skis")
    public String skis(Map<String,Object> model) {
        List<Ski> skis = skiRepository.findAll();
        SkiComparator skiComparator = new SkiComparator();
        skis.sort(skiComparator);
        model.put("skis",skis);
        return "skis";
    }

    @PostMapping("/skis")
    public String addSkis(@RequestParam String name, @RequestParam String firm, @RequestParam String length, @RequestParam Integer price, Map<String,Object> model) {
        Ski ski = new Ski(name,length,firm,price);
        skiRepository.save(ski);
        List<Ski> skis = skiRepository.findAll();
        SkiComparator skiComparator = new SkiComparator();
        skis.sort(skiComparator);
        model.put("skis",skis);
        return "redirect:/skis";
    }

    @PostMapping("/skisUpdates")
    public String updateSki(@RequestParam String name, @RequestParam String firm, @RequestParam String length, @RequestParam Integer price, @RequestParam Integer id, Map<String,Object> model) {
        Ski ski = skiRepository.findById(id).get();
        ski.setName(name);
        ski.setFirm(firm);
        ski.setLength(length);
        ski.setPrice(price);
        skiRepository.save(ski);
        List<Ski> skis = skiRepository.findAll();
        SkiComparator skiComparator = new SkiComparator();
        skis.sort(skiComparator);
        model.put("skis",skis);
        return "redirect:/skis";
    }

    @RequestMapping(value = "skis/delete/{id}",method = RequestMethod.GET)
    public String deleteSki(@PathVariable Integer id, Map<String,Object> model) {
        Iterable<Reservation> reservations = reservationRepository.findAll();
        if (reservations.iterator().hasNext()) {
            for (Reservation reservation : reservations) {
                if(!(reservation.getSki().getId().equals(id))) {
                    skiRepository.deleteById(id);
                }
            }
        } else {
            skiRepository.deleteById(id);
        }
        List<Ski> skis = skiRepository.findAll();
        SkiComparator skiComparator = new SkiComparator();
        skis.sort(skiComparator);
        model.put("skis",skis);
        return "redirect:/skis";
    }
}
