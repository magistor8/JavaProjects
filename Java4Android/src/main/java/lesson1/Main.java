package lesson1;

public class Main {

    public static void main (String[] args) {
//        printHello();
//        testVars();
//        sumVarsandPrint(4, 6); // alt + enter
//        testcalculateSalary();
        testchackAp();

        // Движение ctrl + shift вниз
    }

    public static void printHello () {
        System.out.println("Hello World");
    }

    public static void testVars () {

        int varA;
        varA = 9;
        int varB = 5;
        System.out.println(varA / (double)varB);

        double doubleVarA = 9.0;
        double doubleVarB = 5.1;

        System.out.println(doubleVarA / doubleVarB);

        char chr1 = '┴';
        char chr2 = 19998;

        System.out.println(chr1);
        System.out.println(chr2);

        boolean isTrue = true;

        String helloStr = "Hello";
        String worldStr = "World";

        System.out.println(helloStr + " " + worldStr);

    }

    private static void sumVarsandPrint(int a, int b) {

        System.out.println(a + b);

    }

    private static void testcalculateSalary() {
        final int TAX_RUSSIA = 13; // Константа
        int salary1 = calculateSalary(100000, TAX_RUSSIA);
        int salary2 = calculateSalary(25000, TAX_RUSSIA);
        int salary3 = calculateSalary(500000, 15);
        System.out.println(salary1 + salary2 + salary3);
    }

    private static int calculateSalary(int salary, int tax) {
        int salaryAfterTax = (int)(salary - (salary * tax / 100));
        return salaryAfterTax;
    }

    private static void testchackAp() {
        chackAp(5);
        chackAp(4);
        chackAp(3);
        chackAp(2);
        chackAp(1);
        chackAp(0);
    }

    private static void chackAp(int ap) {
        System.out.printf("Ученик получил оценку: %d -- ", ap);

        if (ap == 5) {
            System.out.println("Молодец!, так держать");
        } else if (ap == 4) {
            System.out.println("Не плохо, но ты можешь лучше");
        } else if (ap >= 1 && ap <= 3) {
            System.out.println("Готовь уроки лучше");
        } else {
            System.out.println("Не мухлюй, говори правду");
        }

    }
}
