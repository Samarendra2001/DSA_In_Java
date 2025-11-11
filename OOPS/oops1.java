public class oops1 {
    public static void main(String args[]){
        Dog dog1 = new Dog(); // dog1 is object of class Dog which is created using new keyword
        dog1.name = "Tommy";
        dog1.bark();
        Dog dog2 = new Dog();
        dog2.name = "Bruno";
        dog2.eat();
    }
}

class Dog {
    String name;
    int age;
    String color;

    void bark(){
        System.out.println(name + " is barking");
    }

    void eat(){
        System.out.println(name + " is eating");
    }
}