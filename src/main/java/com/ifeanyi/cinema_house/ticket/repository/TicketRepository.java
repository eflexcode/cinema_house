package com.ifeanyi.cinema_house.ticket.repository;

import com.ifeanyi.cinema_house.ticket.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket,String> {

    Page<Ticket> findByOwnerId(String ownerId, Pageable pageable);
    Page<Ticket> findByHallId(String hallId, Pageable pageable);

}
