package exceptions;

class A {
    public void dis() {

    }
}

class B extends A {
    @Override
    public void dis() throws NullPointerException {

    }
}
public class SubSuperException {

    public void calc(Integer i) {
        System.out.println("int calc");
    }

    public void calc(String i) {
        System.out.println("String calc");
    }
    public static void main(String[] args) {
//        new SubSuperException().calc(null);
    }
}
