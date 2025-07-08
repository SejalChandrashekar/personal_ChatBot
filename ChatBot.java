import java.io.IOException;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntentStore store = new IntentStore();
        HistoryTracker tracker = new HistoryTracker();
        ChatLogger logger;

        try {
            logger = new ChatLogger("chat_log.txt");
        } catch (IOException e) {
            System.out.println(" Failed to create log file.");
            return;
        }

        System.out.println(" Welcome to SejalBot!");
        while (true) {
            System.out.print("You: ");
            String input = sc.nextLine().trim();
            tracker.add("You: " + input);

            String response = store.getResponse(input);
            System.out.println("Bot: " + response);
            tracker.add("Bot: " + response);

            try {
                logger.log("You: " + input);
                logger.log("Bot: " + response);
            } catch (IOException e) {
                System.out.println("Failed to write to log.");
            }

            if (input.equalsIgnoreCase("bye")) break;
        }

        try {
            logger.close();
        } catch (IOException e) {
            System.out.println(" Failed to close log file.");
        }

        tracker.printHistory();
        System.out.println(" Chat saved to 'chat_log.txt'");
    }
}

