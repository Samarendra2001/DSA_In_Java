package oops3.learnPackage;

public class Person {
    public String name; // public access modifier
    int age; // default access modifier
    private String password; // private access modifier
    protected String address; // protected access modifier

    public void setPassword(String pwd){
        this.password = pwd;
    }

    public String getPassword(){
        return this.password;
    }
}
