
import java.util.*;

public class Strings {
    public static void main(String args[]){
    StringBuilder sb = new StringBuilder("Sam");
    System.out.println(sb);
    //char AT
    System.out.println(sb.charAt(0));
    //set char At(it means replace the index with some other char)
    sb.setCharAt(0,'R');//for character use '' and for string use ""
    System.out.println(sb);

    //inserting 
    sb.insert(0,'S');
    System.out.println(sb);
    sb.insert(2,'a');
    System.out.println(sb);

    //delete
    sb.delete(2,3);
    System.out.println(sb);
    //append
    sb.append("m");
    sb.append("m");
    System.out.println(sb);
    //length
    System.out.println(sb.length());

    }
}
