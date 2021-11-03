package FunctionInterfaceTest;

import java.util.function.Supplier;

public class SupplierInterfaceTest {
    //无参数，有返回值
    public static void main(String[] args) {

        Supplier<String> supplier = () -> "呵呵哈！";
        System.out.println(supplier.get());
    }
}
