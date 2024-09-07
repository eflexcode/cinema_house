package com.ifeanyi.cinema_house.ticket.service;

import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.ticket.entity.Ticket;
import com.ifeanyi.cinema_house.ticket.model.TicketModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {

    Ticket create(TicketModel ticketModel) throws NotFoundException, ForbiddenException;// buy ticket

    Ticket get(String id) throws NotFoundException;

    List<Ticket> getByOwnerId(String ownerId, Pageable pageable);

    List<Ticket> getByHallId(String hallId, Pageable pageable);

    void delete(String admin, String id) throws NotFoundException, ForbiddenException;


}
