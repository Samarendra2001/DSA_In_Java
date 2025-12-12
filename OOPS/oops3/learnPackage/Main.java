package oops3.learnPackage;
import oops3.learnPackage.Person;
import oops3.learnPackage.Teacher;
// import oops3.learnPackage.*; // this will import all the classes of that package
// here we have created a package named learnPackage and inside that we have created 2 classes Person and Teacher
// now we will use these classes in this main file by importing them
// we can either import them one by one or we can import the whole package using *

// public access modifier is available everywhere
// default access modifier is only available inside the package
// private access modifier is only available inside the class
// protected access modifier is available inside the package and also in the child class outside the package

public class Main {
    public static void main(String args[]){
        Person p1 = new Person();
        Teacher t1 = new Teacher();
    
        p1.name = "John"; // public access modifier
        p1.age = 25; // default access modifier
        // p1.password = "mypassword"; // private access modifier - will give error
        p1.setPassword("mypassword"); // using public method to set private variable
        System.out.println("Password: " + p1.getPassword()); // using public method to get private variable
        p1.address = "123 Main St"; // protected access modifier
    }
}