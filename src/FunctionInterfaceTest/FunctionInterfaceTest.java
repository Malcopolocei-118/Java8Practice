package FunctionInterfaceTest;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionInterfaceTest {
    public static void main(String[] args) {
        //有传参，有返回
        Function<Integer, Integer> function1 = it -> it * it;
        Function<Integer, Integer> function2 = it -> it + it;
        Function<Integer, Integer> function3 = Function.identity();

        System.out.println(function1.apply(3));
        System.out.println(function1.compose(function2).apply(3));
        System.out.println(function1.andThen(function2).apply(3));
        System.out.println(function3.apply(3));
        System.out.println("----------------------------------------------");

        List<Integer> integerList = createList();
        System.out.println(integerList.stream().map(function1).collect(Collectors.toList()));
    }

    private static List<Integer> createList() {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            integerList.add(i);
        }
        return integerList;
    }
}
