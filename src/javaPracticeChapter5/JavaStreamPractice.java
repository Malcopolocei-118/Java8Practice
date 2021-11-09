package javaPracticeChapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class JavaStreamPractice {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //可以重构，比如： 抽一个方法专门获取TraderList

        printBaseLine(1);
        //1. 找出2011年发生的所有交易，并按照交易额进行排序
        List<Transaction> transactionsIn2011 = transactions.stream()
                .filter(it -> Objects.equals(it.getYear(), 2011))
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(transactionsIn2011);

        //2. 交易员都在哪些不同的城市工作过？
        printBaseLine(2);
        List<String> baseCities = transactions.stream()
                .map(it -> it.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(baseCities);

        //3. 查询所有来自于剑桥的交易员，按照姓名排序
        printBaseLine(3);
        List<Trader> traderFromCambridge = transactions.stream()
                .filter(it -> it.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Transaction::getValue))
                .map(Transaction::getTrader)
                .collect(Collectors.toList());
        System.out.println(traderFromCambridge);

        printBaseLine(4);
        //4. 返回所有交易员的姓名字符串、按照字母顺序排序
        List<String> traderNames = transactions.stream()
                .map(it -> it.getTrader().getName())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(traderNames);

        printBaseLine(5);
        //5. 有没有交易员是来自米兰的？
        boolean isTraderFromMilan = transactions.stream()
                .anyMatch(it -> it.getTrader().getCity().equals("Milan"));
        System.out.println(isTraderFromMilan);

        printBaseLine(6);
        //6. 打印生活在剑桥的交易员的所有交易额
        int valueInCambridge = transactions.stream()
                .filter(it -> it.getTrader().getCity().equals("Cambridge"))
                //这里要用mapToInt，否则返回是一个Optional<Integer>
                .mapToInt(Transaction::getValue)
                .sum();
        System.out.println(valueInCambridge);

        printBaseLine(7);
        //7. 返回所有交易的最大金额
        OptionalInt maxValue = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .mapToInt(Transaction::getValue)
                .findFirst();
        System.out.println(maxValue);

        printBaseLine(8);
        //8. 返交易额中交易最小的交易
        Optional<Transaction> minValueTransaction = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(minValueTransaction);
    }

    public static void printBaseLine(int mark) {
        System.out.println("------ 需求: " + mark + " ------");
    }

}
