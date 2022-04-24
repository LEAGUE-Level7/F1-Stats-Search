package org.jointheleague.api.F1Stats.presentation;


import org.jointheleague.api.F1Stats.repository.dto.Constructor;
import org.jointheleague.api.F1Stats.repository.dto.ConstructorTable;
import org.jointheleague.api.F1Stats.repository.dto.Example;
import org.jointheleague.api.F1Stats.repository.dto.LocResponse;
import org.jointheleague.api.F1Stats.repository.dto.MRData;
import org.jointheleague.api.F1Stats.service.LocService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LocControllerTest {
	
	private LocController locController;
	
	@Mock
    private LocService locService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        locController = new LocController(locService);
    }
    
    @Test
    void givenGoodQuery_whenGetResults_thenReturnListOfResults() {
        //given
        String query = "2019";
        
        MRData result = new MRData();
        ConstructorTable ct = new ConstructorTable();
        List<Constructor> cs = new ArrayList<Constructor>();
        cs.add(new Constructor());
        ct.setConstructors(cs);
        result.setConstructorTable(ct);
        
        MRData expectedResults = result;
        
        when(locService.getResults(query)).thenReturn(expectedResults);

        //when
        MRData actualResults = locController.getResults(query);

        //then
        assertEquals(expectedResults, actualResults);
    }

    @Test
    void givenBadQuery_whenGetResults_thenThrowsException() {
        //given
        String query = "Java";

        //when
        
        //then
        Throwable exceptionThrown = assertThrows(ResponseStatusException.class, () -> locController.getResults(query));
        assertEquals(exceptionThrown.getMessage(), "404 NOT_FOUND \"Result(s) not found.\"");
    }
}
