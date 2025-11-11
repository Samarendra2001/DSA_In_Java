public class MethodOverloading {
    public static void main(String args[]){
        Greet g1 = new Greet();
        g1.greet();
        g1.greet("Aman");
        g1.greet("Aman", "Evening");
    }
}

// Method Overloading Example

class Greet {
    void greet(){
        System.out.println("Hello! Good Morning");
    }

    void greet(String name){
        System.out.println("Hello! " + name + " Good Morning");
    }

    void greet(String name, String timeOfDay){
        System.out.println("Hello! " + name + " Good " + timeOfDay);
    }
}
// method overloading depends on number of paramater and type of parameter not on return type
