package learnjava;

public class caseWhenTest {
    public static void testCase(int x){
        switch (x) {
            case 1 : {System.out.println("5 or 6");}

            case 4 : {
//do something else
            }
            case 5 : System.out.println("5 or 6");
            default : System.out.println("Not 1,3,4,5,6");
        }
    }

    static class TheParentClass {
        private int prop;
        public TheParentClass(int prop){
            this.prop = prop;
        }
// methods follow
    }

    static class TheChildClass extends TheParentClass{
        private int x;
        private String prop;
        private String anotherProp = "abc";
        public TheChildClass(String prop){
            super(42);
            this.prop = prop;
        }
        public TheChildClass(int arg1, String arg2){
            super(arg1);
            this.prop = arg2;
        }
// methods follow
    }
}
