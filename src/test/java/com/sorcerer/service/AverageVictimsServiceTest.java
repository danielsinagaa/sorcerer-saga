package com.sorcerer.service;

import com.sorcerer.model.AverageVictimsResponse;
import com.sorcerer.model.Person;
import com.sorcerer.model.PersonData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AverageVictimsServiceTest {

    @InjectMocks
    private AverageVictimsService averageVictimsService;

    @Mock
    private PersonData personData;

    @Test
    public void testExecute() {
        Person person1 = new Person(10, 12);
        Person person2 = new Person(13, 17);

        when(personData.getPerson1()).thenReturn(person1);
        when(personData.getPerson2()).thenReturn(person2);

        AverageVictimsResponse response = averageVictimsService.execute(personData);

        assertEquals(4.5, response.getAverageVictims());
    }
}