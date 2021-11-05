package myfunctionInterfaceTest;

public class MyFunctionInterfaceTest {
    public static void main(String[] args) {
        MyFunctionInterface greeting = System.out::println;
        greeting.print("呵呵哈！");
    }
}
