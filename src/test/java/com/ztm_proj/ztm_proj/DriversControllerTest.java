package com.ztm_proj.ztm_proj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztm_proj.ztm_proj.entity.Drivers;
import com.ztm_proj.ztm_proj.service.DriversService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(DriversController.class)
public class DriversControllerTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DriversService driversService;

    @Test
    public void testGetAllDrivers() throws Exception {
        List<Drivers> drivers = Arrays.asList(new Drivers(), new Drivers());
        when(driversService.getAllDrivers()).thenReturn(drivers);

        mockMvc.perform(get("/drivers/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));
    }



    @Test
    public void addDriversTest() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/drivers/adddriver")
                        .content(asJsonString(new Drivers(1, "FirstAndLastName", "Line")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateDrivers() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .put("/drivers/updatedriver")
                        .content(asJsonString(new Drivers(1, "Test","TestLinia")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetDrivers() throws Exception {
        Drivers drivers = new Drivers();
        when(driversService.getDriversById(1)).thenReturn(Optional.of(drivers));

        mockMvc.perform(get("/drivers/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }

    @Test
    public void testDeleteAllDrivers() throws Exception {
        mockMvc.perform(delete("/drivers/all"))
                .andExpect(status().isOk());

        verify(driversService, times(1)).deleteAllDrivers();
    }

    @Test
    public void testDeleteDrivers() throws Exception {
        mockMvc.perform(delete("/drivers/1"))
                .andExpect(status().isOk());

        verify(driversService, times(1)).deleteDriversById(1);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}