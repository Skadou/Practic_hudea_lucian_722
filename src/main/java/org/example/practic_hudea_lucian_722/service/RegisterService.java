package org.example.practic_hudea_lucian_722.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.practic_hudea_lucian_722.model.Register;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterService {
    private List<Register> registers = new ArrayList<>();

    //a)Lesen Sie die Daten aus den JSON-Dateien tributes.json, events.json und gifts.json und speichern Sie diese in Java-Listen.
    // Geben Sie anschließend auf der Konsole aus:
    //Anzahl der Tribute
    public void loadTributes(String filepath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.registers = mapper.readValue(new File(filepath) , new TypeReference<List<Register>>(){});

        System.out.println("Anzahl der Tribute: " + registers.size());
        for(Register r : registers)
            System.out.println(r.getId() + " | " + r.getName() + " | " + "D"+r.getDistrict() + " | " + r.getStatus() + " | " + r.getSkillLevel());
    }

    //Anzahl der Ereignisse
     public void numberofEvents() throws IOException {
         ObjectMapper mapper = new ObjectMapper();
         List<Object> events = mapper.readValue(new File("events.json") , new TypeReference<List<Object>>(){});

         System.out.println("Anzahl der Ereignisse: " + events.size());
     }

    //Anzahl der Sponsorengeschenke
    public void numberofGifts() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        List<Object> gifts = mapper.readValue(new File("gifts.json") , new TypeReference<List<Object>>(){});

        System.out.println("Anzahl der Sponsorengeschenke: " + gifts.size());
    }

    //alle Tribute (jeweils eine Zeile)
    public void numberofTributes() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Register> tributes = mapper.readValue(new File("tributes.json"), new TypeReference<List<Register>>(){});

        System.out.println("Anzahl der Tribute: " + tributes.size());

    }
}
