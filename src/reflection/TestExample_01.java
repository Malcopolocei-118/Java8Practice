package reflection;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

// getConstructor
public class TestExample_01 {
    public static void main(String[] args) {
        Example_01 example_01 = new Example_01("01", "02", "03");
        printConstructorMessage(example_01);
    }

    public static void printConstructorMessage(Example_01 example_01) {
        Class example = example_01.getClass();
        Constructor[] constructors = example.getDeclaredConstructors();

        Arrays.stream(constructors).forEach(
                it -> {
                    System.out.println("该构造方法是有带有可变数量的参数 "
                    + it.isVarArgs());
                    System.out.println("该构造方法的入口参数类型依次为：");
                    Arrays.stream(it.getParameterTypes()).forEach(System.out::println);
                }
        );
    }
}
