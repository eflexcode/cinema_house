package com.ifeanyi.cinema_house.ticket.service;

import com.ifeanyi.cinema_house.Util;
import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.hall.entity.Hall;
import com.ifeanyi.cinema_house.hall.service.HallService;
import com.ifeanyi.cinema_house.ticket.entity.Ticket;
import com.ifeanyi.cinema_house.ticket.model.TicketModel;
import com.ifeanyi.cinema_house.ticket.repository.TicketRepository;
import com.ifeanyi.cinema_house.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;
    private final HallService hallService;
    private final UserService userService;

    @Override
    public Ticket create(TicketModel ticketModel) throws NotFoundException, ForbiddenException {

        Hall hall = hallService.get(ticketModel.getHallId());
        Ticket ticket;
        if (hall.getSoldSeat() < hall.getAvailableSeat()) {

            ticket = new Ticket();
            BeanUtils.copyProperties(ticketModel, ticket);
            ticket.setCreatedAt(new Date());

        } else {
            throw new ForbiddenException("Hall is full");
        }

        return repository.save(ticket);
    }

    @Override
    public Ticket get(String id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No ticket found with id: " + id));
    }

    @Override
    public List<Ticket> getByOwnerId(String ownerId, Pageable pageable) {
        return repository.findByOwnerId(ownerId, pageable).toList();
    }

    @Override
    public List<Ticket> getByHallId(String hallId, Pageable pageable) {
        return repository.findByHallId(hallId, pageable).toList();
    }

    @Override
    public void delete(String admin, String id) throws NotFoundException, ForbiddenException {
        Util.isUserAdmin(admin, userService);
        repository.delete(get(id));
    }
}
