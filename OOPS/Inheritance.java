//inheritance
//java has 4 types of inheritance
//unlike c++ java does not have multiple inheritance
//import OOPS.Bank; we can import the package from any file and use it another file
class Shape{
    String color;
}
class Triangle extends Shape{
    //this extend is used for inheritance 
    //that means this triangle class extend or inherit the property of Shape class
}
public class Inheritance {
    public static void main(String args[]){
        Triangle T1 = new Triangle();
        T1.color = "red";
        //Bank.Account account1 = new Bank.Account();//here we have used the information of bank file by importing bank package
        
    }
}
