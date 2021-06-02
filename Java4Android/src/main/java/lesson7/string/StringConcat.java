package lesson7.string;

import java.io.*;
import java.util.Arrays;

public class StringConcat {

    public static void main(String[] args) throws IOException {
        String a1 = "Hello My ";
        String a2 = "Dear World";
        String a3 = a1 + a2;
        a3 = a1.concat(a2);

        String b1 = "Число";
        int b2 = 10;
        String b3 = b1 + b2;
        b3 = b1.concat(String.valueOf(b2));

        String c = "(" + 2 + 3 + ")" + b3 + "!";

        for (char ch : a3.toCharArray()) {
            System.out.print(ch + " ");
        }

        System.out.println(a1.equals(a2));
        System.out.println(a1.compareTo(a2));

        String spaces = "     \n         ";
        System.out.println(spaces.trim());
        System.out.println(spaces == null);
        System.out.println(spaces.isEmpty());
        System.out.println(spaces.isBlank());
        System.out.println(spaces.trim().isEmpty());

        System.out.println(a3.substring(8));
        System.out.println(a3.substring(8, 16));

        for (String s : a3.split("\s+", 3)) {
            System.out.println(s);
        }

        System.out.println(a3.replaceAll("My", "Our"));

        System.out.println(a3.charAt(16));
        System.out.println(a3.indexOf(' ', 9));

        System.out.println(a3.startsWith("Hello"));

        System.out.println(String.join(a1, a2, b1));

        StringBuilder sb = new StringBuilder();
        sb.append(a1);
        sb.append(a2);
        sb.append(b1);
        sb.append(8);
        System.out.println(sb);

    }

    private static String message(boolean b) {
        return "Your char had".concat(b ? " " : "n't ").concat("been found!");
    }
}
