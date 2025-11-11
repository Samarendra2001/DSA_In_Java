public class Constructor {
    public static void main(String args []){
        Complex c1 = new Complex(); // so here object is created and so as the constructor created by default
        c1.printNumber();
        Complex c2 = new Complex(5, 7);
        c2.printNumber();
    }
}

class Complex {
    int a;
    int b;
    Complex(){//this is default constructor it does not have any return type and any parameter
        a=0;
        b=0;
        System.out.println("Constructor called");
    }// default constructor is always created automatically even if we dont create it but if we create any parameterized constructor then default constructor is not created automatically
    Complex(int x, int y){//parameterized constructor
        a = x;
        b = y;
    }
    void printNumber(){
        System.out.println("The complex number is " + a + " + " + b + "i");
    }
}
