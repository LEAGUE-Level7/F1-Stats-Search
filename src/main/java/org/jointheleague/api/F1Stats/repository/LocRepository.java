package org.jointheleague.api.F1Stats.repository;

import java.util.List;

import org.jointheleague.api.F1Stats.repository.dto.Constructor;
import org.jointheleague.api.F1Stats.repository.dto.LocResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class LocRepository {

    private static final String baseUrl = "http://ergast.com/api/f1/";
    private final WebClient webClient;

    public LocRepository() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }

    public List<Constructor> getResults(String year) {

        //http://ergast.com/api/f1/{year}/constructors
    	System.out.println(webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("{year}/constructors.json") // remove .json to have xml
                        .build(Integer.parseInt(year))
                )
                .retrieve()
                .bodyToMono(String.class)
                .block());
    	LocResponse lr = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("{year}/constructors.json") // remove .json to have xml
                        .build(Integer.parseInt(year))
                )
                .retrieve()
                .bodyToMono(LocResponse.class)
                .block();
    	System.out.println(lr);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("{year}/constructors.json") // remove .json to have xml
                        .build(Integer.parseInt(year))
                )
                .retrieve()
                .bodyToMono(LocResponse.class)
                .block()
                .getResults();
    }

}