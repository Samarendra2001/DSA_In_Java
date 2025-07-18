import java.util.HashSet;
import java.util.Iterator;
public class hashSet{
    public static void main(String args[]){
        HashSet<Integer> set = new HashSet<>();
        //insert 
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        //searching
        if(set.contains(2)){
            System.out.println("Set contains 2");
        }
        if(!set.contains(7)){
            System.out.println("does not contain");
        }
        //delete operation
        set.remove(1);
        if(!set.contains(1)){
            System.out.println("does not contain");
        }
        //size
        System.out.println("size of set is " + set.size());
        //print all element
        System.out.println(set);

        //iterator
        Iterator it = set.iterator();
        //next and hasNext() 
        //next means it.next = next element
        //hasNext() = it.hasNext(), it will check whether the 
        //set has any next elemnt or not accordinglt return true or false

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}