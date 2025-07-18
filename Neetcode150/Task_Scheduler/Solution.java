package Task_Scheduler;
// 🔍 Intuition
// We want to schedule tasks such that identical tasks have at least n intervals between them.
// The most frequent task should be executed as soon as possible while ensuring the cooldown is respected.
// 💡 Approach
// Max Heap to Process Most Frequent Tasks First

// The task with the highest frequency should be scheduled first.
// Using a max heap, we ensure we always process the most frequent remaining task.
// Processing in Chunks of n+1

// We can execute at most n+1 different tasks in one cycle.
// If we have fewer than n+1 tasks available, we add only what we have (avoiding unnecessary idle slots).
// Time Calculation

// If there are still tasks left after a cycle, we must wait for n+1 slots before repeating.
// If all tasks are executed, we only add the exact time needed.

import java.util.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        // ✅ Step 1: Count the frequency of each task
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            // Update frequency count for each task
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // ✅ Step 2: Build a max heap (priority queue) based on task frequency
        // We use a max heap to always process the most frequent task first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freqMap.values()); // Only store frequencies in the heap

        // ✅ Step 3: Process tasks while maintaining cooldown periods
        int time = 0; // Keeps track of the total intervals used

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>(); // Temporary list to store tasks being executed in this cycle

            // 🛠 Pick up to `n+1` tasks to execute in this cycle (ensures cooldown of `n` intervals)
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll()); // Get the most frequent remaining task
                }
            }

            // 🛠 Decrease task frequencies and reinsert them if they still need execution
            for (int freq : temp) {
                if (--freq > 0) { // If the task still has remaining occurrences
                    maxHeap.add(freq);
                }
            }

            // ✅ Step 4: Update time
            // - If heap is empty, add the exact number of executed tasks (to avoid extra idle time)
            // - Otherwise, add `n+1` (full cycle to respect the cooldown)
            time += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        return time; // Return the minimum time needed to complete all tasks
    }

    // ✅ Main method to test the implementation
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int result = solution.leastInterval(tasks, n);
        System.out.println("Minimum intervals required: " + result);
    }
}

