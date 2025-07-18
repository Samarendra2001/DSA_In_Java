//package Time_Based_Key-value_Store;
// Intuition:
// We need a way to store key-value pairs with timestamps.
// When retrieving a value, if an exact timestamp isn’t available, we should return the most recent value before that timestamp.
// Using a combination of HashMap and TreeMap helps efficiently store and retrieve values while maintaining the order of timestamps.
// 🛠️ Approach:
// Use a HashMap to store each key.
// The value for each key is a TreeMap that maintains timestamps in sorted order.
// In set(key, value, timestamp):
// Store the value with its corresponding timestamp in the TreeMap.
// In get(key, timestamp):
// If the key exists, use floorEntry() to find the greatest timestamp ≤ given timestamp.
// If found, return the value; otherwise, return an empty string.

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    /**
     * TimeMap class for storing timestamped key-value pairs.
     */
    static class TimeMap {
        // HashMap to store key -> TreeMap of timestamp and value pairs
        private Map<String, TreeMap<Integer, String>> map;

        // Constructor to initialize the HashMap
        public TimeMap() {
            map = new HashMap<>();
        }

        /**
         * Stores the value along with the timestamp for a given key.
         */
        public void set(String key, String value, int timestamp) {
            // If the key is new, create a new TreeMap for it
            // TreeMap keeps timestamps in sorted order
            map.computeIfAbsent(key, k -> new TreeMap<>())
                .put(timestamp, value);  // Store the timestamp and value
        }

        /**
         * Retrieves the value for the given key and timestamp.
         * If no exact timestamp is found, returns the most recent value <= the timestamp.
         */
        public String get(String key, int timestamp) {
            // Get the TreeMap for the key
            TreeMap<Integer, String> treeMap = map.get(key);

            // If the key doesn't exist, return an empty string
            if (treeMap == null) {
                return "";
            }

            // Get the closest timestamp <= the given timestamp
            Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);

            // If no such timestamp exists, return an empty string
            return entry == null ? "" : entry.getValue();
        }
    }

    /**
     * Main method to test the TimeMap class.
     */
    public static void main(String[] args) {
        // Create a new TimeMap object
        TimeMap timeMap = new TimeMap();

        // Store "bar" at timestamp 1 for key "foo"
        timeMap.set("foo", "bar", 1);

        // Retrieve value for key "foo" at timestamp 1 -> Output: "bar"
        System.out.println(timeMap.get("foo", 1));  // Expected: bar

        // Retrieve value for key "foo" at timestamp 3
        // Since no exact timestamp, get the most recent one <= 3 -> Output: "bar"
        System.out.println(timeMap.get("foo", 3));  // Expected: bar

        // Store "bar2" at timestamp 4 for key "foo"
        timeMap.set("foo", "bar2", 4);

        // Retrieve value for key "foo" at timestamp 4 -> Output: "bar2"
        System.out.println(timeMap.get("foo", 4));  // Expected: bar2

        // Retrieve value for key "foo" at timestamp 5 -> Output: "bar2"
        System.out.println(timeMap.get("foo", 5));  // Expected: bar2

        // Retrieve value for a non-existing key -> Output: ""
        System.out.println(timeMap.get("baz", 1));  // Expected: ""
    }
}

