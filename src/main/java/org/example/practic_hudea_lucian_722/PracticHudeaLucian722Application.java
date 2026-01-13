package org.example.practic_hudea_lucian_722;

import org.example.practic_hudea_lucian_722.controller.RegisterController;
import org.example.practic_hudea_lucian_722.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PracticHudeaLucian722Application implements CommandLineRunner {

    @Autowired
    private RegisterController registerController;

    public static void main(String[] args) {
        SpringApplication.run(PracticHudeaLucian722Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- SPRING BOOT HUNGER  GAMES---");

        while (running) {
            System.out.println("\n---------------------");
            System.out.println("\n1. Register (Task 1)");
            System.out.println("0. Exit");
            String choice = scanner.nextLine();

            // Make switch expression null-safe (scanner.nextLine() can be null in some environments)
            if (choice == null) {
                choice = "";
            } else {
                choice = choice.trim();
            }

            switch (choice) {
                case "1":
                    registerController.run(scanner);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }
        scanner.close();
    }

}
