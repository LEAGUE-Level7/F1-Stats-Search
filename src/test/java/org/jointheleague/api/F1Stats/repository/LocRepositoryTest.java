package org.jointheleague.api.F1Stats.repository;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.jointheleague.api.F1Stats.repository.LocRepository;
import org.jointheleague.api.F1Stats.repository.dto.Constructor;
import org.jointheleague.api.F1Stats.repository.dto.ConstructorTable;
import org.jointheleague.api.F1Stats.repository.dto.Example;
import org.jointheleague.api.F1Stats.repository.dto.LocResponse;
import org.jointheleague.api.F1Stats.repository.dto.MRData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class LocRepositoryTest {

    private LocRepository locRepository;

    @Mock
    WebClient webClientMock;

    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    WebClient.ResponseSpec responseSpecMock;

    @Mock
    Mono<LocResponse> LocResponseMonoMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        locRepository = new LocRepository(webClientMock);
    }

    @Test
    void whenGetResults_thenReturnListOfResults() {
        //given
        LocResponse locResponse = new LocResponse();
        
        String query = "2019";
        
        MRData result = new MRData();
        ConstructorTable ct = new ConstructorTable();
        List<Constructor> cs = new ArrayList<Constructor>();
        cs.add(new Constructor());
        ct.setConstructors(cs);
        result.setConstructorTable(ct);
        
        MRData expectedResults = result;
        
        locResponse.setMRData(expectedResults);

        when(webClientMock.get()).thenReturn(requestHeadersUriSpecMock);
        
        when(requestHeadersUriSpecMock.uri((Function<UriBuilder, URI>) any())).thenReturn(requestHeadersSpecMock);
        
        when(requestHeadersSpecMock.retrieve()).thenReturn(responseSpecMock);
        
        when(responseSpecMock.bodyToMono(LocResponse.class)).thenReturn(LocResponseMonoMock);
        
        when(LocResponseMonoMock.block()).thenReturn(locResponse);

        //when
        MRData actualResults = locRepository.getResults(query);

        //then
        assertEquals(expectedResults, actualResults);
    }

}