package com.ztm_proj.ztm_proj.service;

import com.ztm_proj.ztm_proj.dao.RoutesDao;
import com.ztm_proj.ztm_proj.entity.Routes;
import com.ztm_proj.ztm_proj.entity.Tickets;
import com.ztm_proj.ztm_proj.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public List<Tickets> getAllTickets() {
        return this.ticketRepository.findAll();
    }

    public Tickets addTickets(Tickets route) {
        return this.ticketRepository.save(route);
    }

    public Optional<Tickets> getTicketsById(int id) {
        return this.ticketRepository.findById(id);
    }

    public Tickets updateTickets(Tickets trip) {
        return this.ticketRepository.save(trip);
    }

    public void deleteTicketsById(int id) {
        this.ticketRepository.deleteById(id);
    }

    public void deleteAllTickets() {
        this.ticketRepository.deleteAll();
    }
}
