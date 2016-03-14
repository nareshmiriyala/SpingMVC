package com.dellnaresh.web;

import com.dellnaresh.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nareshm on 3/1/2016.
 */
@Controller
public class ReservationRestController {
    private final ReservationRepository
            reservationRepository;

    @Autowired
    public ReservationRestController(
            ReservationRepository reservationRepository) {
        this.reservationRepository =
                reservationRepository;
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/reservations")
    public String
    getReservations(Model model) {
        model.addAttribute("reservations", this.reservationRepository.findAll());
        return "greet";
    }
}