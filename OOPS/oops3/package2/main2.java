package oops3.package2;
import oops3.learnPackage.Person;
public class main2 {
    // here we will try to access the classes of package1
    public static void main(String args[]){
    Person p1 = new Person();
    p1.name = "Alice"; // public access modifier
     //p1.age = 30; // default access modifier - will give error
    // p1.password = "secret"; // private access modifier - will give error
    // p1.address = "456 Elm St"; // protected access modifier - will give error
    // to make the protected variable accessible here we need to extend the Person class
    // so let's create a new class Student that extends Person
    }
}