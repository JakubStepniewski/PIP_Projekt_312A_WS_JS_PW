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
@WebMvcTest(TripsController.class)
public class TripsControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TripService tripService;

    @Test
    public void testGetAllTrips() throws Exception {
        List<Trips> trips = Arrays.asList(new Trips(), new Trips());
        when(tripService.getAllTrips()).thenReturn(trips);

        mockMvc.perform(get("/trips/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));
    }

    @Test
    public void addTripsTest() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/trips/addtrip")
                        .content(asJsonString(new Trips(1L,"RouteId","ServiceId","TripId","tripHeadsign",1L,1L)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void testTripsRoutes() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .put("/trips/updatetrip")
                        .content(asJsonString(new Trips(1L,"RouteId","ServiceId","TripId","tripHeadsign",1L,1L)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTrips() throws Exception {
        Trips trips = new Trips();
        when(tripService.getUserById(1)).thenReturn(Optional.of(trips));

        mockMvc.perform(get("/trips/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }

    @Test
    public void testDeleteAllTrips() throws Exception {
        mockMvc.perform(delete("/trips/all"))
                .andExpect(status().isOk());

        verify(tripService, times(1)).deleteAllTrips();
    }

    @Test
    public void testDeleteTrips() throws Exception {
        mockMvc.perform(delete("/trips/1"))
                .andExpect(status().isOk());

        verify(tripService, times(1)).deleteTripsById(1);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
