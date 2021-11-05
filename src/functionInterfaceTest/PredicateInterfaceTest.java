package functionInterfaceTest;

import java.util.function.Predicate;

public class PredicateInterfaceTest{
    //有传参，返回一个boolean类型
    public static void main(String[] args) {
        Predicate<Integer> predicate1 = it -> it > 0;
        Predicate<Integer> predicate2 = it -> it < 20;

        System.out.println(predicate1.test(21));
        System.out.println(predicate1.and(predicate2).test(21));
        System.out.println(predicate1.or(predicate2).test(21));
        System.out.println(predicate1.negate().test(21));
        System.out.println(predicate2.negate().test(21));
        System.out.println(Predicate.isEqual(21).test(21));
    }
}
