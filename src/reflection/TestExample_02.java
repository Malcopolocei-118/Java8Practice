package reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

//getFields
public class TestExample_02 {
    public static void main(String[] args) {
        Example_02 example_02  = new Example_02();
        Class<? extends Example_02> example = example_02.getClass();

        //获取成员变量
        Field[] fields = example.getDeclaredFields();
        Arrays.stream(fields).forEach(
                it -> {
                    System.out.println("成员变量为: " + it);
                    Class<?> fieldType = it.getType();
                    System.out.println("成员变量类型为: " + fieldType);
                    System.out.println("------");
                }
        );
        

    }
}
