package com.grupo11.hootel.controller;

import com.grupo11.hootel.entity.Reserva;
import com.grupo11.hootel.entity.ReservaHotel;
import com.grupo11.hootel.exceptions.HootelException;
import com.grupo11.hootel.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GerenteReservaHotelController {

    private ReservaService reservaService;

    public GerenteReservaHotelController(ReservaService ReservaService) {
        this.reservaService = ReservaService;
    }

    @ModelAttribute("todasReservas")
    public List<Reserva> populateReservas(Model model) {
        try {
            return reservaService.lerTodasReservas(ReservaHotel.class);
        } catch (HootelException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return new ArrayList<>();
        }
    }

    @GetMapping("/mostrarReservas")
    public String mostrarReservas(Model model){
        /*model.addAttribute("reserva", new Reserva());*/
        model.addAttribute("reserva", new ReservaHotel());

        return "reservas_gerente";
    }

    @PostMapping("/addReserva")
    public String criarNovaReserva(Model model) {

        Reserva reserva = reservaService.criarReserva(new ReservaHotel());
        model.addAttribute("novaReserva", reserva);

        return "redirect:/mostrarReservas";
    }

    @PostMapping("/removeReserva")
    public String removeReserva(@Valid @ModelAttribute("reserva") Reserva reserva,
                                BindingResult bindingResult,
                                Model model){

        if (bindingResult.hasErrors()){
            return "reservas_gerente";
        }

        try {
            reservaService.deletarReserva(reserva);
        }catch (HootelException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "reservas_gerente";
        }

        return "redirect:/mostrarReservas";
    }
}
