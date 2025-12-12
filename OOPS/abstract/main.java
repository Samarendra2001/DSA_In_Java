//package abstract;

public class main {
    
}

abstract class Animal {
    abstract void sound();
    // void sleep() {
    //     System.out.println("Zzz");
}
// class Dog extends Animal {
//     void sound() {
//         System.out.println("Woof");
//     }
// }
//Or
abstract class Dog extends Animal{};

//Animal a = new Animal();//cannot create the object of abstract class
Animal d = new Dog();//we can create the object of subclass