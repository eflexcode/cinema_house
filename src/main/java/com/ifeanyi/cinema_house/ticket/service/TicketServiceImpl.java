package com.ifeanyi.cinema_house.ticket.service;

import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.hall.entity.Hall;
import com.ifeanyi.cinema_house.hall.service.HallService;
import com.ifeanyi.cinema_house.ticket.entity.Ticket;
import com.ifeanyi.cinema_house.ticket.model.TicketModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{

    private TicketService ticketService;
    private HallService hallService;

    @Override
    public Ticket create(TicketModel ticketModel) throws NotFoundExceptionHandler {

        Hall hall = hallService.get(ticketModel.getHallId());
        if (hall.getSoldSeat() == hall.getAvailableSeat() ){

        }

        return null;
    }

    @Override
    public Ticket get(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
