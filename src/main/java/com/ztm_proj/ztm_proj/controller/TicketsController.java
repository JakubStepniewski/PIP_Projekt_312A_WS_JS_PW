package com.ztm_proj.ztm_proj.controller;

import com.ztm_proj.ztm_proj.entity.Routes;
import com.ztm_proj.ztm_proj.entity.Tickets;
import com.ztm_proj.ztm_proj.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketsController {
    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Tickets> getAllTickets() {
        return this.ticketService.getAllTickets();
    }


    @RequestMapping(value = "/addticket", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Tickets addTickets(@RequestBody Tickets tickets) {
        return this.ticketService.addTickets(tickets);
    }


    @RequestMapping(value = "/updateticket", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Tickets updateTicketse(@RequestBody Tickets tickets) {
        return this.ticketService.updateTickets(tickets);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Tickets> getTickets(@PathVariable int id) {
        return this.ticketService.getTicketsById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllTickets() {
        this.ticketService.deleteAllTickets();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTickets(@PathVariable int id) {
        this.ticketService.deleteTicketsById(id);
    }

}