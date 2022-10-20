import java.time.LocalDateTime;
import java.util.Map;

public class Journal {

    private String entry;
    private Map <LocalDateTime, String> entries;

    public Journal() {

    }

    public Map<LocalDateTime, String> getEntries() {
        return entries;
    }

    public void addEntry(String entry){

        entries.put(LocalDateTime.now(),entry);
    }
}


