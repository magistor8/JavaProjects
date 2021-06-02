package lesson7.string;

import java.io.*;

public class StringFile {

    public static void main(String[] args) throws IOException {

//        File file = new File("X:\\Ya.Disk\\work\\Lessons\\java4android\\src\\main\\resources\\lib\\text.txt");
        File file = new File("src/main/resources/lib/text.txt");

/*        if (!file.exists()) {
            file.createNewFile();
        }  else {
            file.deleteOnExit();
        }*/

        var is = new BufferedReader(new FileReader(file));
        System.out.println(new String(is.readLine()));

        var sb = new StringBuilder();
        int n;
        while ( (n = is.read()) != -1) {
            sb.append((char)n);
        }

        var input = new FileInputStream(file);
        int size = input.available();

        for (int i = 0; i < size; i++) {
            System.out.println((char)input.read());
        }

        System.out.println(sb);
    }
}
