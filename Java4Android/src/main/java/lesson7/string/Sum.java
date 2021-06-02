package lesson7.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Sum {

    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("src/main/resources/lib/input.txt");
        File output = new File("src/main/resources/lib/output.txt");

        Scanner scanner = new Scanner(input);
        PrintWriter pw = new PrintWriter(output);

        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();

        pw.print(a.divide(b));

        scanner.close();
        pw.close();
    }
}
