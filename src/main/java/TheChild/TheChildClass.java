package TheChild;

import TheParent.TheParentClass;

public class TheChildClass extends TheParentClass {
    private String name;
    private String prop;
    public TheChildClass(String prop){
        // super(42);
        this.prop = prop;
    }
    public TheChildClass(int arg1, String arg2){
        super(arg1);
        this.prop = arg2;
    }

    public void value(){
        name = "Shan";
        // 呼叫父類別的method
        super.value();
        System.out.println(name);
        System.out.println(super.name);
    }

// methods follow

    public static void main(String[] args) {
        //要先有一個子類別的宣告。才能再去呼叫其method。
        TheChildClass child = new TheChildClass(5,"123");
        System.out.println(child.toString());
        System.out.println(child);
        child.value();
        //System.out.println(test.prop);
        //System.out.println(test);
    }

    @Override
    public String toString() {
        return "TheChildClass{" +
                "prop='" + prop + '\'' +
                '}';
    }
}
