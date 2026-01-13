package org.example.practic_hudea_lucian_722.controller;

import org.example.practic_hudea_lucian_722.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RegisterController {
    private final RegisterService service;

    @Autowired
    public RegisterController(RegisterService service) {
        this.service = service;
    }

    public void run(Scanner scanner) {
        try {
            //1
            // a) initializare
            service.loadTributes("tributes.json");

            // b) numar evenimente
            System.out.println("--- Number of Events ---");
            service.numberofEvents();

            // c) numar cadouri
            System.out.println("--- Number of Gifts ---");
            service.numberofGifts();

            // d) numar tributi
            System.out.println("--- Number of Tributes ---");
            service.numberofTributes();

            //2
            System.out.println("\n--- Filter Tributes by District and Status ---");
            System.out.println("Enter district number (1-12): ");
            int choice = scanner.nextInt();
            service.filterTributesByDistrictAndStatus(choice);

            //3
            System.out.println("\n--- Sorted Tributes ---");
            service.sortTributes();

            //4
            System.out.println("\n--- Writing Sorted Tributes to File ---");
            service.writeSortedTributesToFile();



        } catch (Exception e) {
            System.err.println("Err at data processing: " + e.getMessage());
        }
    }


}
