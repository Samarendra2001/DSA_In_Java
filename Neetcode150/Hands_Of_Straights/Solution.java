//package Hands_Of_Straights;

import java.util.TreeMap;

public class Solution {
    public static boolean isNStraightHand(int [] hand , int groupSize) {
        // Implementation goes here
        if(hand.length % groupSize !=0) return false;
        TreeMap<Integer, Integer> cardCounts = new TreeMap<>();
        // iterate throght the hand and count the occurences and adding to the tree map if present then update the frequency by adding 1 else just add it with frequency 1
        for(int card: hand){
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }
        // forming groups
        while(!cardCounts.isEmpty()){
            int firstCard = cardCounts.firstKey();
            for(int card = firstCard; card < firstCard + groupSize; card++){
                // check if the card is present in the TreeMap
                if(!cardCounts.containsKey(card)){
                    return false;
                }
                int count = cardCounts.get(card);
                if(count == 1){
                    cardCounts.remove(card);
                } else {
                    cardCounts.put(card, count - 1);
                }
            }
        }
        return true;
    }
    public static void main(String [] args) {
        int [] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println("Hands of Straights Problem Solution: " + isNStraightHand(hand, groupSize));
    }
}
