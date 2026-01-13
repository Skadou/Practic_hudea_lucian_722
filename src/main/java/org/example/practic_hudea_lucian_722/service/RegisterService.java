package org.example.practic_hudea_lucian_722.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.practic_hudea_lucian_722.model.Register;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RegisterService {
    private List<Register> registers = new ArrayList<>();

    //a)Lesen Sie die Daten aus den JSON-Dateien tributes.json, events.json und gifts.json und speichern Sie diese in Java-Listen.
    // Geben Sie anschließend auf der Konsole aus:
    //Anzahl der Tribute
    public void loadTributes(String filepath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.registers = mapper.readValue(new File(filepath), new TypeReference<List<Register>>() {
        });

        System.out.println("Anzahl der Tribute: " + registers.size());
        for (Register r : registers)
            System.out.println(r.getId() + " | " + r.getName() + " | " + "D" + r.getDistrict() + " | " + r.getStatus() + " | " + r.getSkillLevel());
    }

    //Anzahl der Ereignisse
    public void numberofEvents() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Object> events = mapper.readValue(new File("events.json"), new TypeReference<List<Object>>() {
        });

        System.out.println("Anzahl der Ereignisse: " + events.size());
    }

    //Anzahl der Sponsorengeschenke
    public void numberofGifts() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Object> gifts = mapper.readValue(new File("gifts.json"), new TypeReference<List<Object>>() {
        });

        System.out.println("Anzahl der Sponsorengeschenke: " + gifts.size());
    }

    //alle Tribute (jeweils eine Zeile)
    public void numberofTributes() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Register> tributes = mapper.readValue(new File("tributes.json"), new TypeReference<List<Register>>() {
        });

        System.out.println("Anzahl der Tribute: " + tributes.size());
    }

    //2) Filtren nach distrikt und statusLesen Sie von der Tastatur eine ganze Zahl D, die ein Distrikt repräsentiert. Geben Sie anschließend nur die Tribute aus, die gleichzeitig folgende Bedingungen erfüllen:
    //● district == D
    //● status == ALIVE
    //Die Ausgabe erfolgt im selben Format wie in Aufgabe 1.

    public void filterTributesByDistrictAndStatus(int district) {
        System.out.println("Tribute aus Distrikt " + district + " mit Status ALIVE:");
        for (Register r : registers) {
            if (r.getDistrict() == district && r.getStatus() == org.example.practic_hudea_lucian_722.Status.ALIVE) {
                System.out.println(r.getId() + " | " + r.getName() + " | " + "D" + r.getDistrict() + " | " + r.getStatus() + " | " + r.getSkillLevel());
            }
        }
    }

    //3)Sortierung der Tribute
    //Sortieren Sie die Liste der Tribute wie folgt:
    //● absteigend nach skillLevel
    //● bei gleichem skillLevel aufsteigend nach name
    //Geben Sie die sortierte Liste auf der Konsole aus.

    public void sortTributes() {
        registers.sort((r1, r2) -> {
            int skillComp = Integer.compare(r2.getSkillLevel(), r1.getSkillLevel());
            return (skillComp != 0) ? skillComp : r1.getName().compareTo(r2.getName());
        });

        System.out.println("Sortierte Liste der Tribute:");
        for (Register r : registers) {
            System.out.println(r.getId() + " | " + r.getName() + " | " + "D" + r.getDistrict() + " | " + r.getStatus() + " | " + r.getSkillLevel());
        }
    }

    //4)Schreiben in eine Datei Schreiben Sie die in Aufgabe 3 sortierte Liste der Tribute in die Datei tributes_sorted.txt. Jeder Tribut soll in einer eigenen Zeile gespeichert werden, im selben Format wie bei der Konsolenausgabe.
    public void writeSortedTributesToFile() throws IOException {
        try (var writer = new java.io.PrintWriter(new File("tributes_sorted.txt"))) {
            for (Register r : registers) {
                writer.println(r.getId() + " | " + r.getName() + " | " + "D" + r.getDistrict() + " | " + r.getStatus() + " | " + r.getSkillLevel());
            }
        }
    }

    //5) Punktberechnung
    //Das Kapitol definiert feste Regeln zur Berechnung der Punkte für jedes Ereignis. Implementieren Sie für alle folgenden EventTyp-Werte je eine Regel:
    //● FOUND_SUPPLIES → computedPoints = points + 2 * day
    //● INJURED → computedPoints = points - day
    //● ATTACK → computedPoints = points * 2 + day
    //● HELPED_ALLY → computedPoints = points + 5
    //● SPONSORED → computedPoints = points + 10
    //Berechnen Sie für die ersten 5 Ereignisse aus events.json die computedPoints und geben Sie pro Ereignis eine Zeile aus:
    //Ausgabeformat:
    //Event <id> -> rawPoints=<points> -> computedPoints=<computedPoints>
    //Ausgabe:
    //Event 1 -> rawPoints=10 -> computedPoints=12
    //Event 2 -> rawPoints=-5 -> computedPoints=-7
    //Event 3 -> rawPoints=15 -> computedPoints=31
    //Event 4 -> rawPoints=8 -> computedPoints=13
    //Event 5 -> rawPoints=12 -> computedPoints=14

    public void calculateEventPoints() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> events = mapper.readValue(new File("events.json"), new TypeReference<List<Map<String, Object>>>() {
        });

        for (int i = 0; i < Math.min(5, events.size()); i++) {
            Map<String, Object> event = events.get(i);
            int id = (int) event.get("id");
            int points = (int) event.get("points");
            int day = (int) event.get("day");
            String eventType = (String) event.get("eventType");

            int computedPoints = 0;
            switch (eventType) {
                case "FOUND_SUPPLIES":
                    computedPoints = points + 2 * day;
                    break;
                case "INJURED":
                    computedPoints = points - day;
                    break;
                case "ATTACK":
                    computedPoints = points * 2 + day;
                    break;
                case "HELPED_ALLY":
                    computedPoints = points + 5;
                    break;
                case "SPONSORED":
                    computedPoints = points + 10;
                    break;
            }

            System.out.println("Event " + id + " -> rawPoints=" + points + " -> computedPoints=" + computedPoints);
        }
    }
}