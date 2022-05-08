package org.jointheleague.api.F1Stats.presentation;

import org.jointheleague.api.F1Stats.repository.dto.Constructor;
import org.jointheleague.api.F1Stats.repository.dto.ConstructorTable;
import org.jointheleague.api.F1Stats.repository.dto.Example;
import org.jointheleague.api.F1Stats.repository.dto.LocResponse;
import org.jointheleague.api.F1Stats.repository.dto.MRData;

import org.jointheleague.api.F1Stats.service.LocService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(LocController.class)
class LocControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocService locService;

    @Test
    public void givenGoodQuery_whenSearchForResults_thenIsOkAndReturnsResults() throws Exception {
        //given
    	String year = "2019";
    	String name = "alpha";
        
        MRData result = new MRData();
        ConstructorTable ct = new ConstructorTable();
        List<Constructor> cs = new ArrayList<Constructor>();
        
        Constructor c = new Constructor();
        c.setName(name);
        cs.add(c);
        
        ct.setConstructors(cs);
        result.setConstructorTable(ct);
        
        MRData expectedResults = result;
        

        when(locService.getResults(year)).thenReturn(expectedResults);

        //when
        
        //then
        MvcResult mvcResult = mockMvc.perform(get("/searchLocResults?year=" + year))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ConstructorTable.Constructors[0].name", is(name)))
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

    @Test
    public void givenBadQuery_whenSearchForResults_thenIsNotFound() throws Exception {
        //given
        String year = "1900";

        //when
        
        //then
        mockMvc.perform(get("/searchLocResults?year=" + year))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}