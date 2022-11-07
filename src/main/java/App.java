import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class App {

    //TODO: Need to figure how to reformat the entry to something more legible
LocalDateTime ldt = LocalDateTime.now();
//LocalDateTime currentd
    public static void main(String[] args) throws RuntimeException {
        //initializes scanner to enable inputs to the Pad file
        Scanner input = new Scanner(System.in);
        File pad = new File("C:\\Users\\carto\\AppData\\Roaming\\JetBrains\\IdeaIC2022.1\\scratches\\Pad");
        //decision is used to keep create another entry or to close out the app.
        String decision = "";
        while (true) {
            //this while loop basically keeps the app running until user decides to close it.
            System.out.println("What is on your mind?");

            try (PrintWriter writer = new PrintWriter(new FileWriter(pad, true))) {

                String entry = input.nextLine();
                writer.println(LocalDateTime.now() + " " + entry);

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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



