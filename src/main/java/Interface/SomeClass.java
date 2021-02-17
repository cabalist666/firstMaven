package Interface;

interface SomeInterface {
    void method1();
    String method2(int i);
    //String s1;
    String s2 ="Abc";
    static String someMethod() {
        return "abc";
    }
}

public class SomeClass implements SomeInterface{
    public void method1(){
//method body
    }
    public String method2(int i) {
//method body
        return "abc";
    }

    public static void main(String[] args) {
        SomeInterface si = new SomeClass();
        System.out.println(SomeInterface.someMethod()); //prints: abc
    }

}

