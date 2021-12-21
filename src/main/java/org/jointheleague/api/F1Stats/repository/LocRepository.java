package org.jointheleague.api.F1Stats.repository;

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

    public String getResults(String year) {

        //http://ergast.com/api/f1/{year}/constructors
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("{year}/constructors.json") // remove .json to have xml
                        .build(Integer.parseInt(year))
                )
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}