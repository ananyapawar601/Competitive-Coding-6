// Designing of Logger Rate Limiter

/* 

Time Complexity (TC):
O(1) → Each operation (lookup, insertion, or update) in the HashMap takes constant time on average.

Space Complexity (SC):
O(N) → In the worst case, where all messages are unique, the map will store up to N messages, 
where N is the number of unique messages received in a 10-second window.

*/

class Logger { 
    private HashMap<String, Integer> map; // To store the last logged timestamp for each message 

    public Logger() { 
        map = new HashMap<>(); // Initialize the hashmap
    } 

    public boolean shouldPrintMessage(int timestamp, String message) {
        // Check if the message exists and was logged within the last 10 seconds
        if (map.containsKey(message) && timestamp - map.get(message) < 10) { 
            return false; // Reject logging as it's within the cooldown period
        } 

        // Log the message and update the timestamp
        map.put(message, timestamp); 
        return true; // Allow logging
    } 
}

