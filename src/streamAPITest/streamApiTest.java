package streamAPITest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.function.Function.identity;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class streamApiTest {

    public static void main(String[] args) {
        // - builder
        List<String> str = Stream.<String>builder().add("a").add("b").add("c").build().collect(Collectors.toList());
        System.out.println(str);

        // - generator
        Stream<String> strGenerator = Stream.generate(() -> "俺是供给者").limit(10);
        System.out.println(strGenerator.collect(Collectors.toList()));

        // - iterate
        Stream<Integer> strIterate = Stream.iterate(40, n -> n + 40).limit(40);
        System.out.println(strIterate.collect(Collectors.toList()));

        // - Primitives
        IntStream intStream = IntStream.rangeClosed(1, 3);
        System.out.println(intStream.findFirst());

        // - Stream Referencing
        Stream<String> stream = Stream.of("a", "b", "c").filter(element -> element.contains("b"));
        Optional<String> anyElement = stream.findAny();
        System.out.println(anyElement);
        // - Exception: streams has already been operated upon or closed: 终端操作会使得Stream无法访问
        try {
            Optional<String> testElement = stream.findAny();
            System.out.println(testElement);
        } catch (IllegalStateException ignored) {
        }

        // - Stream Pipeline: Source -> Intermediate Operations -> Terminal operation
        List<String> testPipeLine = Stream.<String>builder().add("malco").add("polp").add("cei").build()
                .map(it -> it.substring(0, 3))
                .collect(Collectors.toList());
        System.out.println(testPipeLine);

        separatorLine("1");

        //Lazy Invocation
        List<String> strLazy = Arrays.asList("abc1", "abc2", "abc3");
        List<String> testLazy = strLazy.stream()
                .filter(it -> {
                    log.println("filter() is called");
                    return it.contains("2");
                })
                .map(it -> {
                    log.println("map() is called");
                    return it.toUpperCase();
                })
                .collect(Collectors.toList());
        separatorLine("2");

        Optional<String> testLazy2 = strLazy.stream().filter(element -> {
            log.println("filter() was called!");
            return element.contains("2");
        }).map(element -> {
            log.println("map() was called!");
            return element.toUpperCase();
        }).findFirst();


        //Stream Reduction - reduce
        separatorLine("终结操作-reduce");
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(integerList.stream().reduce((a, b) -> a + b));
        System.out.println(integerList.stream().reduce(10, (a, b) -> a + b));
        //test for reduce(combiner)
        System.out.println(integerList.stream().reduce(10, (a, b) -> a + b, (a, b) -> a + b));
        //12 - 13 = -1, 11 - (-1) = 12, and the result is 12.
        System.out.println(integerList.parallelStream().reduce(10, (a, b) -> a + b, (a, b) -> a - b));

        //Stream Reduction - collect
        separatorLine("终结操作-collect");
        List<Product> products = Arrays.asList(new Product(1, "南瓜", 15)
                , new Product(2, "黄瓜", 8)
                , new Product(3, "冬瓜", 12)
                , new Product(4, "苦瓜", 16));
        Map<Integer, Product> productMap = products.stream().collect(Collectors.toMap(Product::getId, identity()));
        Map<Integer, List<Product>> productMap2 = products.stream().collect(Collectors.groupingBy(Product::getId));
        String listToStringTest = products.stream().map(Product::getName).collect(Collectors.joining(",","[","]"));
        System.out.println(listToStringTest);
    }

    public static void separatorLine(String mark) {
        System.out.println("----------分割线" + mark + "----------");
    }
}
