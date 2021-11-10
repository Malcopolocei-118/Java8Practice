package reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

//getMethods
public class TestExample_03 {
    public static void main(String[] args) throws NoSuchMethodException {
        Example_03 example_03 = new Example_03();
        //getDeclaredMethods 和 getMethods的区别： 前者返回类本身（不包含继承）的所有方法；后者仅返回所有的public方法
        Method[] declaredMethods = example_03.getClass().getDeclaredMethods();
        printMessage(declaredMethods);

        System.out.println("============大大分割线================");
        //getMethods()
        Method[] methods = example_03.getClass().getMethods();
        printMessage(methods);

        System.out.println("============大大分割线================");
        //获取指定方法
        Method method = example_03.getClass().getMethod("publicMethod", int.class);
        System.out.println("获取的指定方法名称为: " + method.getName());
    }

    private static void printMessage(Method[] methods) {
        Arrays.stream(methods).forEach(
                it -> {
                    System.out.println("----------");
                    System.out.println("方法名称为： " + it.getName());
                    System.out.println("方法是否带有可变参数： " + it.isVarArgs());
                    System.out.println("方法的传参类型依次为： ");
                    Arrays.stream(it.getParameterTypes()).forEach(System.out::println);
                }
        );
    }
}
