package reflection;

//getMethods
public class Example_03 {
    static void staticMethod() {
        System.out.println("执行staticMethod()方法");
    }

    public int publicMethod(int input) {
        System.out.println("执行publicMethod()方法");
        return input * 100;
    }

    protected int protectedMethod(String str, int input) {
        System.out.println("执行protectedMethod()方法");
        return Integer.parseInt(str) + input;
    }

    private String privateMethod(String... strings) {
        System.out.println("执行 privateMethod()方法");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i]);
        }
        return stringBuffer.toString();
    }
}
