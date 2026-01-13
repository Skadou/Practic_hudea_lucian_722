package org.example.practic_hudea_lucian_722.controller;

import org.example.practic_hudea_lucian_722.service.RegisterService;
import org.springframework.stereotype.Component;

@Component
public class RegisterController {
    private final RegisterService service;

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    public void run() {
        try {
            // a) initializare
            service.loadTributes("tributes.json");

            // b) numar evenimente
            service.numberofEvents();

            // c) numar cadouri
            service.numberofGifts();

            // d) numar tributi
            service.numberofTributes();
        } catch (Exception e) {
            System.err.println("Eroare la procesarea datelor: " + e.getMessage());
        }
    }


}
