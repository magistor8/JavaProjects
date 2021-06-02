package lesson12;

public class Main {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        t.setName("New thread");
        t.setPriority(10);
//        t.setDaemon(true);
        System.out.println(t);
//        t.resume();
    }
}
