package com.example.Noble.JournalClient;

import com.example.Noble.JournalServer.JournalEntry;

import java.io.*;
import java.util.Scanner;


public class JournalCLI {

    //TODO: Need to figure how to reformat the entry to something more legible
    // TODO: gotta figure out how to prevent the app from resetting db each time.
    private ClientPrompter clientPrompter = new ClientPrompter();
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws RuntimeException {

//        JournalEntry jE;
//        ConsoleService consoleService = new ConsoleService();

        //initializes scanner to enable inputs to the Pad file
        //decision is used to keep create another entry or to close out the app.
//        String decision = "";
        JournalCLI cli = new JournalCLI();

        cli.run();

    }


    private void run() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            clientPrompter.printMainMenu();
            menuSelection = Integer.parseInt(input.nextLine());
            if (menuSelection == 1) {
                clientPrompter.listEntries();
            } else if (menuSelection == 2) {
                clientPrompter.createEntry();
            } else if (menuSelection == 3) {
                clientPrompter.updateEntry();
            } else if (menuSelection == 4) {
                clientPrompter.deleteEntry();
            } else if (menuSelection == 0) {
                System.out.println("Talk to you later");

                continue;
            } else {
                // anything else is not valid
                System.out.println("Invalid Selection");
            }
            clientPrompter.pause();
        }
    }

//        while (true) {
//            //this while loop basically keeps the app running until user decides to close it.
//            System.out.println("What is on your mind?");
//
//                            String entry = input.nextLine();
//
//            System.out.println("From a scale of 0-100, how do you feel?");
//
//            Long mood = Long.valueOf(input.nextLine());
//
//            System.out.println("Did you take any drugs or medication?");
//
//            String meds = input.nextLine();
//
//        jE = new JournalEntry(entry,mood,meds);
//        consoleService.addJe(jE);
//
//            while (decision.equalsIgnoreCase("")) {
//                System.out.println("Is that all for today? (Y/N)");
//                decision = input.nextLine();
//                if (decision.equalsIgnoreCase("y")) {
//                    System.out.println("Talk to you later");
//                    System.exit(1);
//                } else if (!decision.equalsIgnoreCase("n")) {
//                    System.out.println("wrong entry. try again.");
//                    decision = "";
//                }
//            }
//            decision = "";
//
//
//        }
}




