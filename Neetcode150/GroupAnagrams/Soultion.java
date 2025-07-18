package GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Soultion {
    public static List<List<String>> groupAnagrams(String[] strs){
        //If the input array strs is empty, there are no strings to group, so return an empty list.
        if(strs.length==0){
            return new ArrayList();
        }
        //this ans map will store key and anagrams like Key:"a#1#e#1#t#1"---> value ["eat,"ate","tea"]
        Map<String, List> ansMap = new HashMap<>();
        int count []= new int[26];
        for(String s:strs){
            Arrays.fill(count,0);//count is an array of size 26 initialized with 0. Each index corresponds to a letter ('a' to 'z').
            for(char c:s.toCharArray()){
                count[c-'a']++;//For each character c in the string s, increment the count at index c - 'a'.and make it 1
            }
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<26;i++){
                sb.append("#");//Create a unique string representation of the count array using a delimiter (#) between counts.
                sb.append(count[i]);//For "eat": The count array becomes [#1#1#0...#1], representing a:1, e:1, t:1.
            }
            String key = sb.toString();
            if(!ansMap.containsKey(key)){//If the key doesn't exist in the map, add a new entry for it with an empty list.
                ansMap.put(key,new ArrayList());// Add key with a new empty list: ansMap = {"#1#0#0...#1#0#1"->[]}
            }
            ansMap.get(key).add(s);//Append the string s to the list associated with its key.
        }
        return new ArrayList(ansMap.values());
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }
}
