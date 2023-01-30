package com.ztm_proj.ztm_proj.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztm_proj.ztm_proj.controller.RoutesController;
import com.ztm_proj.ztm_proj.entity.Drivers;
import com.ztm_proj.ztm_proj.entity.Routes;
import com.ztm_proj.ztm_proj.entity.StopTimes;
import com.ztm_proj.ztm_proj.entity.Stops;
import com.ztm_proj.ztm_proj.service.DriversService;
import com.ztm_proj.ztm_proj.service.RouteService;
import com.ztm_proj.ztm_proj.service.StopTimesService;
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
@WebMvcTest(StopTimesController.class)
public class StoptimesControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private StopTimesService stopTimesService;

    @Test
    public void testGetAllStopTimes() throws Exception {
        List<StopTimes> stoptimes = Arrays.asList(new StopTimes(), new StopTimes());
        when(stopTimesService.getAllStopTimes()).thenReturn(stoptimes);

        mockMvc.perform(get("/stoptime/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));
    }

    @Test
    public void addStopTimesTest() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/stoptime/addstoptime")
                        .content(asJsonString(new StopTimes(2,"TripId","Time",1,1)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void testUpdateStopTimes() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .put("/stoptime/updatestoptime")
                        .content(asJsonString(new StopTimes(2,"TripId","Time",1,1)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStopTimes() throws Exception {
        StopTimes stopTimes = new StopTimes();
        when(stopTimesService.getStopTimesById(4)).thenReturn(Optional.of(stopTimes));

        mockMvc.perform(get("/stoptime/4"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }

    @Test
    public void testDeleteAllStopTimes() throws Exception {
        mockMvc.perform(delete("/stoptime/all"))
                .andExpect(status().isOk());

        verify(stopTimesService, times(1)).deleteAllStopTimes();
    }

    @Test
    public void testDeleteStopTimes() throws Exception {
        mockMvc.perform(delete("/stoptime/1"))
                .andExpect(status().isOk());

        verify(stopTimesService, times(1)).deleteStopTimesById(1);
    }


    @Test
    public void testGetRoutesByTripId() throws Exception {
        StopTimes stopTimes = new StopTimes();
        when(stopTimesService.getStopTimesByTripId("5555_32")).thenReturn(Optional.of(stopTimes));

        mockMvc.perform(get("/stoptime/serviceid/5555_32"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
