package com.example.Noble.Journal;

import com.example.Noble.Journal.Journal.JournalEntry;
import com.example.Noble.Journal.Journal.JournalEntryController;

import java.io.*;
import java.util.Scanner;


public class App {

    //TODO: Need to figure how to reformat the entry to something more legible
    //TODO:Gotta change datastructure to DB

    public static void main(String[] args) throws RuntimeException {

        JournalEntry jE;

        //initializes scanner to enable inputs to the Pad file
        Scanner input = new Scanner(System.in);
        File pad = new File("C:\\Users\\carto\\AppData\\Roaming\\JetBrains\\IdeaIC2022.1\\scratches\\Pad");
        //decision is used to keep create another entry or to close out the app.
        String decision = "";
        while (true) {
            //this while loop basically keeps the app running until user decides to close it.
            System.out.println("What is on your mind?");

                            String entry = input.nextLine();

            System.out.println("From a scale of 0-100, how do you feel?");

            Long mood = Long.valueOf(input.nextLine());

            System.out.println("Did you take any drugs or medication?");

            String meds = input.nextLine();

        jE = new JournalEntry(entry,mood,meds);
//            try (PrintWriter writer = new PrintWriter(new FileWriter(pad, true))) {
//
//                String entry = input.nextLine();
//                writer.println(LocalDateTime.now() + " " + entry);
//
//            } catch (FileNotFoundException e) {
//                System.out.println(e.getMessage());
//                System.exit(1);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }


            while (decision.equalsIgnoreCase("")) {
                System.out.println("Is that all for today? (Y/N)");
                decision = input.nextLine();
                if (decision.equalsIgnoreCase("y")) {
                    System.out.println("Talk to you later");
                    System.exit(1);
                } else if (!decision.equalsIgnoreCase("n")) {
                    System.out.println("wrong entry. try again.");
                    decision = "";
                }
            }
            decision = "";


        }
    }
}



