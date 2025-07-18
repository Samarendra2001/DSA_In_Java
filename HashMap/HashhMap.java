import java.util.HashMap;
import java.util.*;


// hashmap stores pair
//like rollno and student name
//key should be unique
//key,value
//and it is unordered map that means
//it does not come sorted like it doesn't come how it is inserted
public class HashhMap {
    public static void main(String args []){
        HashMap<String, Integer> map = new HashMap<>();


        //insertion
        //here country is key that means it should be unique
        //and population is value which can be similar

        map.put("India",120);
        map.put("China",125);
        map.put("Usa",30);
        map.put("Russia",20);

        System.out.println(map);
        map.put("India",130);//it will update if key is already there
        System.out.println(map);

        //search
        if(map.containsKey("China")){
            System.out.println("key is present");
        }else System.out.println("key is not there");

        //getting the correspondense value

        System.out.println(map.get("India"));
        System.out.println(map.get("brazil"));//it will print null

        //iteration in hashmap
        //another syntax of for loop for iteration
        int arr[]= {2,3,5};
        for(int val :arr){
            System.out.print(val + " ");
        }
        System.out.println();

        //for map iteration we use this 1type of for loop
        //for(int val:arr) exactly same syntax 
        //here e is the variable we created where the valuw will be stored
        //Map.Entry<String,Integer> is the type like int 
        for(Map.Entry<String,Integer> e:map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        //similarly we can get using keySet
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key+ " " + map.get(key));
        }
        //removing element from map
        map.remove("China");
        System.out.println(map);
    }
}
