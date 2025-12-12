# in a file there will be multiple class but only one public class which should be same as the file name nothing else.
# A class is not allocated memory when it is defined. An object is allocated memory when it is created.
# Class is logical entity whereas objects are physical entities.
# A class is declared only once. On the other hand, we can create multiple objects of a class..
# class name should start with capital but it should be camal case if two word

## Method OverLoading :-

* Two or more methods can have the same name inside the same class if they accept different arguments.This is known as method Overloading.

## Constructor

* Constructors are invoked implicitly when you instantiate objects..
* Rules :- The name of constructor should be the same as the class and a java constructor must not have a return type.
* A constructor is automatically created by the java compiler if it is not explicitly defined this is also called default constructor.
* A constructor can be overloaded but can not be overridden..It cannot be abstract or static or final.

## This Keyword :-

* This keyword is used to refer to the current object inside a method or a constructor.
* We mostly use this keyword to remove any Ambiguity in Variable Names. We can also use this to invoke methods of the current class or to invoke a constructor of the current class.

## Method Overriding

* if a subclass provides the specific implementation of the method that has been declared by one of its parent class, it is known as method overriding.
* Method overriding is also known as runtime polymorphism. Hence, we can achieve Polymorphosm in Java with the help of inheritance.


## static method or block loads first even before the main block..1st static block will load then main method will be called

## super 
it is used to refer the instance of immediate parent class

* super and this keyword should be called 1st in a class means the 1st line..this and super thats why cant be used together bcz both is wriiten as the first line in a class or constructor.