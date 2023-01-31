package com.ztm_proj.ztm_proj.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztm_proj.ztm_proj.entity.*;
import com.ztm_proj.ztm_proj.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TicketsController.class)
public class TicketControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private TicketService ticketService;


    @Test
    public void testGetAllTicket() throws Exception {
        List<Tickets> tickets = Arrays.asList(new Tickets(), new Tickets());
        when(ticketService.getAllTickets()).thenReturn(tickets);

        mockMvc.perform(get("/tickets/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));
    }

    @Test
    public void addTicketTest() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/tickets/addtickets")
                        .content(asJsonString(new Tickets(1,"TicketName","TicketType", 1.1f)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void testUpdateTicket() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .put("/tickets/updateticket")
                        .content(asJsonString(new Tickets(1,"TicketName","TicketType", 1.1f)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTicket() throws Exception {
        Tickets tickets = new Tickets();
        when(ticketService.getTicketsById(1)).thenReturn(Optional.of(tickets));

        mockMvc.perform(get("/tickets/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }

    @Test
    public void testDeleteAllTicket() throws Exception {
        mockMvc.perform(delete("/tickets/all"))
                .andExpect(status().isOk());

        verify(ticketService, times(1)).deleteAllTickets();
    }

    @Test
    public void testDeleteTicket() throws Exception {
        mockMvc.perform(delete("/tickets/1"))
                .andExpect(status().isOk());

        verify(ticketService, times(1)).deleteTicketsById(1);
    }



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
