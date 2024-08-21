package com.ifeanyi.cinema_house.ticket.repository;

import com.ifeanyi.cinema_house.ticket.entity.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket,String> {
}
