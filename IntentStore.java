import java.util.HashMap;
import java.util.Map;

public class IntentStore {
    private Map<String, String> intents;

    public IntentStore() {
        intents = new HashMap<>();
        intents.put("hello", "Hi there! I'm SejalBot.");
        intents.put("who are you", "I'm a Java chatbot built using DSA concepts.");
        intents.put("sql", "SQL stands for Structured Query Language.");
        intents.put("os", "An operating system manages hardware and software resources.");
        intents.put("bye", "Goodbye! Have a great day!");
    }

    public String getResponse(String input) {
        return intents.getOrDefault(input.toLowerCase(), "Sorry, I don't understand that.");
    }
}

