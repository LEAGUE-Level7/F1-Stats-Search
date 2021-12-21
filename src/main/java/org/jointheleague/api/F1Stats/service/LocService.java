package org.jointheleague.api.F1Stats.service;

import org.jointheleague.api.F1Stats.repository.LocRepository;
import org.springframework.stereotype.Service;

@Service
public class LocService {

    private final LocRepository locRepository;

    public LocService(LocRepository locRepository) {
        this.locRepository = locRepository;
    }

    public String getResults(String year){
        return locRepository.getResults(year);
//        return "Constructors for " + year + " season.";
    }

}