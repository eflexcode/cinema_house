package com.ifeanyi.cinema_house.ticket.controller;

import com.ifeanyi.cinema_house.exception.ForbiddenExceptionHandler;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.hall.entity.Hall;
import com.ifeanyi.cinema_house.ticket.entity.Ticket;
import com.ifeanyi.cinema_house.ticket.model.TicketModel;
import com.ifeanyi.cinema_house.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/api/ticket/")
    public Ticket create(TicketModel ticketModel) throws NotFoundExceptionHandler, ForbiddenExceptionHandler {
        return ticketService.create(ticketModel);
    }
    @GetMapping("/api/ticket/")
    public Ticket get(String id) throws NotFoundExceptionHandler {
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
    public void delete(@PathVariable String admin,@PathVariable String id) throws NotFoundExceptionHandler {
        ticketService.delete(admin, id);
    }
}
