package com.ifeanyi.cinema_house.ticket.service;

import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.ticket.entity.Ticket;
import com.ifeanyi.cinema_house.ticket.model.TicketModel;

public interface TicketService {

    Ticket create(TicketModel ticketModel) throws NotFoundExceptionHandler;// buy ticket

    Ticket get(String id);

    void delete(String id);


}
