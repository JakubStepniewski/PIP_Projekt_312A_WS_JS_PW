package com.ztm_proj.ztm_proj.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztm_proj.ztm_proj.controller.RoutesController;
import com.ztm_proj.ztm_proj.entity.Drivers;
import com.ztm_proj.ztm_proj.entity.Routes;
import com.ztm_proj.ztm_proj.entity.Stops;
import com.ztm_proj.ztm_proj.service.DriversService;
import com.ztm_proj.ztm_proj.service.RouteService;
import com.ztm_proj.ztm_proj.service.StopsService;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(StopsController.class)
public class StopsControllerTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private StopsService stopsService;

    @Test
    public void testGetAllStops() throws Exception {
        List<Stops> stops = Arrays.asList(new Stops(), new Stops());
        when(stopsService.getAllStops()).thenReturn(stops);

        mockMvc.perform(get("/stops/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));
    }

    @Test
    public void addStopsTest() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/stops/addstop")
                        .content(asJsonString(new Stops(2,11L,"Nazwa",1.1,2.2,0)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void testUpdateStops() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .put("/stops/updatestop")
                        .content(asJsonString(new Stops(2,11L,"Nazwa",1.1,2.2,0)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStops() throws Exception {
        Stops stops = new Stops();
        when(stopsService.getStopsById(4)).thenReturn(Optional.of(stops));

        mockMvc.perform(get("/stops/4"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }

    @Test
    public void testDeleteAllStops() throws Exception {
        mockMvc.perform(delete("/stops/all"))
                .andExpect(status().isOk());

        verify(stopsService, times(1)).deleteAllStops();
    }

    @Test
    public void testDeleteStops() throws Exception {
        mockMvc.perform(delete("/stops/1"))
                .andExpect(status().isOk());

        verify(stopsService, times(1)).deleteStopsById(1);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
