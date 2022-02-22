package org.jointheleague.api.F1Stats.service;

import java.util.List;

import org.jointheleague.api.F1Stats.repository.LocRepository;
import org.jointheleague.api.F1Stats.repository.dto.Constructor;
import org.springframework.stereotype.Service;

@Service
public class LocService {

    private final LocRepository locRepository;

    public LocService(LocRepository locRepository) {
        this.locRepository = locRepository;
    }

    public List<Constructor> getResults(String year){
        return locRepository.getResults(year);
//        return "Constructors for " + year + " season.";
    }

}