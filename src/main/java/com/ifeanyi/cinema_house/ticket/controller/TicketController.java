package com.ifeanyi.cinema_house.ticket.controller;

import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.ticket.entity.Ticket;
import com.ifeanyi.cinema_house.ticket.model.TicketModel;
import com.ifeanyi.cinema_house.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/api/ticket/")
    public Ticket create(TicketModel ticketModel) throws NotFoundException, ForbiddenException {
        return ticketService.create(ticketModel);
    }
    @GetMapping("/api/ticket/")
    public Ticket get(String id) throws NotFoundException {
        return ticketService.get(id);
    }
    @GetMapping("/api/ticket/my_ticket/{id}")
    public List<Ticket> getByOwnerId(@PathVariable String id, Pageable pageable) {
        return ticketService.getByOwnerId(id, pageable);
    }
    @GetMapping("/api/ticket/movie_hall/{id}")
    public List<Ticket> getByHallId(@PathVariable String id, Pageable pageable) {
        return ticketService.getByHallId(id,pageable);
    }
    @DeleteMapping("/api/ticket/{admin}/{id}")
    public void delete(@PathVariable String admin,@PathVariable String id) throws NotFoundException, ForbiddenException {
        ticketService.delete(admin, id);
    }
}
