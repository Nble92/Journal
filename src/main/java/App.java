import java.io.*;
import java.nio.channels.NonWritableChannelException;
import java.security.KeyStore;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class App {
    private Scanner page = new Scanner(System.in);
    private LocalDateTime date = LocalDateTime.now();

    private static final Map<LocalDateTime,String> journal = new HashMap<>();

    public App() throws FileNotFoundException {
    }


    //TODO: Need to figure how to reformat the entry to something more legible
    //TODO: Need to figure how to actually store it to a file (PrintWriter?)

    public static void main(String[] args) throws FileNotFoundException {
        App app = new App();
        Scanner input = new Scanner(System.in);
        File pad = new File("C:\\Users\\carto\\AppData\\Roaming\\JetBrains\\IdeaIC2022.1\\scratches\\Pad");
        boolean running = true;
        if(!running){
            System.exit(0);
        }
        while (running) {
        System.out.println("What is on your mind?");

        try (PrintWriter writer = new PrintWriter(new FileWriter(pad,true))) {

            String entry = input.nextLine();
            writer.println(LocalDateTime.now() + " " + entry);

            journal.put(LocalDateTime.now(), entry);
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            System.out.println(journal);
        System.out.println("Is that all for today? (Y/N)");
        String decision = input.nextLine();
if(decision.equals("y")) {
    System.out.println("Talk to you later");
    running = false;
}


}


    }

    }



