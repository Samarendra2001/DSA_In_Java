//package Partition_Labels;

import java.util.*;

public class Solution {
    public static List<Integer> partitionLabels(String s){
      int [] lastIndex = new int[26];
      for(int i=0;i<s.length();i++){
        lastIndex[s.charAt(i)-'a'] = i;
      }
      List<Integer> partitions = new ArrayList<>();
      int partitionEnd = 0, partitionStart = 0;
      for(int i=0;i<s.length();i++){
        partitionEnd = Math.max(partitionEnd, lastIndex[s.charAt(i)-'a']);
        if(i == partitionEnd){
          partitions.add(partitionEnd - partitionStart + 1);
          partitionStart = i + 1;
        }
      }
      return partitions;
    }
    public static void main(String args []){
        String s = "aaccbd";
        System.out.println("Partition Labels Problem Solution: " + partitionLabels(s));
    }
}
