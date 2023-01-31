package com.ztm_proj.ztm_proj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztm_proj.ztm_proj.controller.RoutesController;
import com.ztm_proj.ztm_proj.entity.Drivers;
import com.ztm_proj.ztm_proj.entity.Routes;
import com.ztm_proj.ztm_proj.service.DriversService;
import com.ztm_proj.ztm_proj.service.RouteService;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(RoutesController.class)
public class RoutesControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private RouteService routeService;

    @Test
    public void testGetAllRoutes() throws Exception {
        List<Routes> routes = Arrays.asList(new Routes(), new Routes());
        when(routeService.getAllRoutes()).thenReturn(routes);

        mockMvc.perform(get("/routes/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));
    }

    @Test
    public void addRoutesTest() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/routes/addroute")
                        .content(asJsonString(new Routes("routeId","AgencyId","routeShortName","routeLongName",0L,"routeColor",123123L,1)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void testUpdateRoutes() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .put("/routes/updateroute")
                        .content(asJsonString(new Routes("routeId","AgencyId","routeShortName","routeLongName",0L,"routeColor",123123L,4)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetDrivers() throws Exception {
        Routes routes = new Routes();
        when(routeService.getRouteById(4)).thenReturn(Optional.of(routes));

        mockMvc.perform(get("/routes/4"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }

    @Test
    public void testDeleteAllRoutes() throws Exception {
        mockMvc.perform(delete("/routes/all"))
                .andExpect(status().isOk());

        verify(routeService, times(1)).deleteAllRoutes();
    }

    @Test
    public void testDeleteRoutes() throws Exception {
        mockMvc.perform(delete("/routes/1"))
                .andExpect(status().isOk());

        verify(routeService, times(1)).deleteTripsById(1);
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}