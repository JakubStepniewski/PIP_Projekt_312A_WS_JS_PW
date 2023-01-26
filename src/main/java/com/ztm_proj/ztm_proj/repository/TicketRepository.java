package com.ztm_proj.ztm_proj.repository;

import com.ztm_proj.ztm_proj.entity.Routes;
import com.ztm_proj.ztm_proj.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository  extends JpaRepository<Tickets, Integer> {

}