public class interfac {
    public static void main(String args[]){
        //Animal a = new Animal();//cannot create the object of abstract class
        Dog d = new Dog();//we can create the object of subclass
        d.sound();
    }
}

interface Animal {
    void sound();
    //void sleep() {
    //    System.out.println("Zzz");
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Woof");
    }
}