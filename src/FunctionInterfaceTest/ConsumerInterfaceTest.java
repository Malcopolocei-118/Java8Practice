package FunctionInterfaceTest;

import java.util.function.Consumer;

public class ConsumerInterfaceTest {
    //有传参，无返回
    //accept 和 andThen 方法, 使用andThen时会先执行andThen接口中的accept，再执行after.accept。消费两次
    public static void main(String[] args) {
        Consumer<String> consumer1 = str -> System.out.print("车名：" + str.split(",")[0]);
        Consumer<String> consumer2 = str -> System.out.println("-->颜色:" + str.split(",")[1]);

        String[] strings = {"奥迪,黑色", "五菱宏光,白色"};

        for (String string: strings) {
            consumer1.andThen(consumer2).accept(string);
        }
    }
}
