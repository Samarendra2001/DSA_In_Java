



class Pen{
    String color;
    String type;

    public void write(){
        System.out.println("Writting something");
    }
    public void printColor(){
        System.out.println(this.color);
    }
}
//interfaces
//we use implements for interfaces like extends for inheritance
//we only define properties in interfaces cant implement
//interfaces does not have any constructors;
//we can use multiple interheritance concept using interfaces
interface Bird{
    public void fly();//access modifier in interface is public or abstract by default we dont have to write public key word explicitly
}
interface Herbivore{

}
class Crow implements Bird{
    public void fly(){
        System.out.println("Fly fast");
    }
}
class Crow1 implements Bird,Herbivore{//multiple inheritance
    public void fly(){
        System.out.println("Fly fast");
    }
}
//Abstraction
abstract class Animal{
    abstract void walk();
    Animal(){
        System.out.println("Animal Constructor created");
    }
    public void eat(){
        System.out.println("Animal eats");
    }
}
class Horse extends Animal{
    Horse(){
        System.out.println("Horse constructor created");
    }
    public void walk(){
        System.out.println("wals with 4 legs");
    }
}
class Student{
    String name;
    int age;
    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
    }
    //constructor non parameterized
    Student(){
        System.out.println("constructor called");
    }
    //parameterized constructor
    Student(String name, int age){
        this.name = name;// here this.name refers to the name of the class Student and another name is the parameter
        this.age = age;
    }
    //copy Constructor
    Student(Student s3){
        this.name = s3.name;
        this.age = s3.age;
    }
}
//java does not have any destructor unlike c++ bcz java has garbage collector. If any varibale or object 
//does not have any use then java automatically delete it
public class OOPS {
    public static void main(String args[]){
        Pen pen1 = new Pen();
        pen1.color = "blue";
        pen1.type = "gel";
        pen1.write();
        Pen pen2 = new Pen();
        pen2.color = "black";
        pen2.type = "gel";
        pen1.printColor();
        pen2.printColor();
        Student s1 = new Student();
        s1.name = "Sam";
        s1.age = 24;
        s1.printInfo();
        Student s2 = new Student("Samar",23);
        s2.printInfo();
        Student s3 = new Student(s2);
        s3.printInfo();
        Horse horse = new Horse();
        horse.walk();
        horse.eat();
    }
}
