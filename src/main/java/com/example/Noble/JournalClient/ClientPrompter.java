package com.example.Noble.JournalClient;

import com.example.Noble.JournalServer.JournalEntry;

import java.util.Arrays;
import java.util.Scanner;

public class ClientPrompter {

    private final Scanner input = new Scanner(System.in);
    private final ConsoleService consoleService = new ConsoleService();

    JournalEntry jE;
    //decision is used to keep create another entry or to close out the app.

    public void printMainMenu() {
        System.out.println();
        System.out.println("----Whats up?----");
        System.out.println("1: List Entries");
        System.out.println("2: Create new entry");
        System.out.println("3: Update existing entry");
        System.out.println("4: Delete entry");
        System.out.println("0: Exit");
        System.out.println();
    }


    public void createEntry(){
        System.out.println("What is on your mind?");

        String entry = input.nextLine();

        System.out.println("From a scale of 0-100, how do you feel?");

        Long mood = Long.valueOf(input.nextLine());

        System.out.println("Did you take any drugs or medication?");

        String meds = input.nextLine();

        jE = new JournalEntry(entry, mood, meds);
        consoleService.addJe(jE);
    }

    public void listEntries() {
        System.out.println("Here are your past entries");
        System.out.println("___________________________");
        System.out.println(Arrays.toString(consoleService.getJeList()));


    }

    public void updateEntry() {
    }

    public void deleteEntry() {
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }
//        while (decision.equalsIgnoreCase("")) {
//            System.out.println("Is that all for today? (Y/N)");
//            decision = input.nextLine();
//            if (decision.equalsIgnoreCase("y")) {
//                System.out.println("Talk to you later");
//                System.exit(1);
//            } else if (!decision.equalsIgnoreCase("n")) {
//                System.out.println("wrong entry. try again.");
//                decision = "";
//            }
//        }
//        decision = "";

//}
}