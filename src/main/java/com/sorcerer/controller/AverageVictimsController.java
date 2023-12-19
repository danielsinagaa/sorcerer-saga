package com.sorcerer.controller;

import com.sorcerer.model.AverageVictimsResponse;
import com.sorcerer.model.PersonData;
import com.sorcerer.service.AverageVictimsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AverageVictimsController {

    private final AverageVictimsService averageVictimsService;

    public AverageVictimsController(AverageVictimsService averageVictimsService){
        this.averageVictimsService = averageVictimsService;
    }

    @PostMapping("/average-victims")
    public AverageVictimsResponse averageVictims(@RequestBody PersonData personData){
        return averageVictimsService.execute(personData);
    }
}
