package core;

public class BaseClass {
    private void foo() {
        System.out.println("In BaseClass.foo()");
    }

    void bar() {
        System.out.println("In BaseClass.bar()");
    }

    public static void foo(Integer i) {
        System.out.println("foo(Integer)");
    }

    public static void foo(short i) {
        System.out.println("foo(short)");
    }

    public static void foo(Long i) {
        System.out.println("foo(long)");
    }

    public static void foo(int... i) {
        System.out.println("foo(int ...)");
    }

    public static void main(String[] args) {
        BaseClass po = new DerivedClass();
        po.foo(); // BASE_FOO_CALL
        po.bar();

        foo(10);
        foo(getVal());

    }

    private static Long getVal() {
        return null;
    }
}

class DerivedClass extends BaseClass {
    void foo() {
        System.out.println("In Derived.foo()");
    }

    void bar() {
        System.out.println("In Derived.bar()");
    }
}