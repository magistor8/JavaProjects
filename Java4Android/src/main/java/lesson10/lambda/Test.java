package lesson10.lambda;

public class Test {
    private final int VAR_X = 10;
    private final int VAR_Y = 25;


    public static void main(String[] args) {

        var test = new Test(System.out::println);

        test.testNoneVar(() -> System.out.println("Hello, world!"));
        test.testOneVar(one -> System.out.println(one));
        test.testOneVar(System.out::println);
        test.testTwoVar((one, two) -> System.out.println(one + " " + two));


    }

    public Test() {
    }

    public Test(ConstVar constVar) {
        constVar.start("Hello, world!");
    }

    private static void helloMessage(String name) {
        System.out.println("Hello, " + name);
    }

    public void testNoneVar(NoneVar obj) {
        obj.start();
    }

    public void testOneVar(OneVar obj) {
        obj.start(VAR_X);
    }

    public void testTwoVar(TwoVar obj) {
        obj.start(VAR_X, VAR_Y);
    }
}
