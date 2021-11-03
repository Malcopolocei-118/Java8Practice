package lambdaTest;

public class Java8LambdaTest {
    public static void main(String args[]){
        Java8LambdaTest tester = new Java8LambdaTest();

        //声明类型
        LambdaExpression1 sum = (int x, int y) -> x + y;

        //无需声明类型
        LambdaExpression1 subtract = (x, y) -> x - y;

        //返回值打括号
        LambdaExpression1 square = (x, y) ->  {return x * y;};

        //返回值不打括号
        LambdaExpression1 divide = (x, y) -> x/y;

        System.out.println(tester.getResult(2, 1, sum));
        System.out.println(tester.getResult(2, 1, subtract));
        System.out.println(tester.getResult(2, 1, square));
        System.out.println(tester.getResult(2, 1, divide));

         LambdaExpression2 printMessage = message -> System.out.println(message);
         printMessage.sentMessage("呵呵哈");
         //下面这种不是很理解:
        System.out.println(square.expression(1, 2));
    }

    interface LambdaExpression1 {
        int expression(int x, int y);
    }

    interface LambdaExpression2 {
        void sentMessage(String message);
    }

    private int getResult(int x, int y, LambdaExpression1 lambadaExpression){
        return lambadaExpression.expression(x, y);
    }
}
