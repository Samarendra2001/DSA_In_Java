//import java.util.*; this will import all the class
//in big project this will create impact regarding memory issue as all the classes will be imported unnecessarily
import java.util.ArrayList;
import java.util.Collections;
public class Basic {
    public static void main(String args[]){
        //defining
        ArrayList<Integer>list = new ArrayList<>();//one way
        // ArrayList<Integer>list1= new ArrayList<Integer>();//anotherway
        // ArrayList<String>list3 = new ArrayList<String>();
        //adding element
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        //get element
        System.out.println(list.get(2));//it wil give letter at index 2
        //add element in between 
        list.add(2,5);//index 2 element 5
        System.out.println(list);

        //set element means set in a particular index replacing another
        System.out.println(list.set(2,5));

        //delete element
        System.out.println(list.remove(3));

        //size
        System.out.println(list.size());

        //loops
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //sorting
        Collections.sort(list);//collections is a class given by java
        System.out.println(list);
        }
}
//why array List
//Size is variable
//we store object here
//array list store in heap