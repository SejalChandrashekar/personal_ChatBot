import java.util.LinkedList;
import java.util.List;

public class HistoryTracker {
    private List<String> history;

    public HistoryTracker() {
        history = new LinkedList<>();
    }

    public void add(String message) {
        history.add(message);
    }

    public void printHistory() {
        System.out.println("\n Chat History:");
        for (String msg : history) {
            System.out.println(msg);
        }
    }

    public List<String> getHistory() {
        return history;
    }
}

