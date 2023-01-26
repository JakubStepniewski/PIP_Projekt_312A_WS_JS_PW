package com.ztm_proj.ztm_proj.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TICKETS", schema = "prog_w")
public class Tickets {
    private Long Id;
    private String TicketName;
    private String TicketType;
    private float TicketPrice;

    public void setId(Long id) {
        this.Id = id;
    }

    @Id
    @Column(name = "ID")
    public Long getId() {
        return Id;
    }

    @Column(name = "TICKET_NAME")
    public String getTicketName() {
        return TicketName;
    }

    @Column(name = "TICKET_NAME")
    public void setTicketName(String ticketName) {
        TicketName = ticketName;
    }

    @Column(name = "TICKET_TYPE")
    public String getTicketType() {
        return TicketType;
    }

    @Column(name = "TICKET_TYPE")
    public void setTicketType(String ticketType) {
        TicketType = ticketType;
    }

    @Column(name = "TICKET_PRICE")
    public float getTicketPrice() {
        return TicketPrice;
    }

    @Column(name = "TICKET_PRICE")
    public void setTicketPrice(float ticketPrice) {
        TicketPrice = ticketPrice;
    }
}
