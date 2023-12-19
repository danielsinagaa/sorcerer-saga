package com.sorcerer.service;

import com.sorcerer.model.AverageVictimsResponse;
import com.sorcerer.model.PersonData;
import org.springframework.stereotype.Service;

@Service
public class AverageVictimsService {

    public AverageVictimsResponse execute(PersonData personData){
        AverageVictimsResponse response = new AverageVictimsResponse();

        Double person1 = (double) victimCount(personData.getPerson1().getYear() - personData.getPerson1().getAge());
        Double person2 = (double) victimCount(personData.getPerson2().getYear() - personData.getPerson2().getAge());

        System.out.println("PERSON 1 = " + person1);
        System.out.println("PERSON 2 = " + person2);

        double answer = (person1 + person2) / 2;

        System.out.println(person1 + " + " + person2 + " = " + answer);

        if (answer < 0 ){
            response.setAverageVictims(-1.0);
        } else response.setAverageVictims(answer);

        return response;
    }

    private int victimCount(int year) {
        if (year <= 0) {
            return 0;
        }

        int[] fibonacci = new int[year + 1];
        fibonacci[1] = 1;

        for (int i = 2; i <= year; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        int victim = 0;
        for (int i = 1; i <= year; i++) {
            victim += fibonacci[i];
        }

        return victim;
    }
}
