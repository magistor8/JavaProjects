package lesson12;

public class TestSyncBlock {

    public static final int STEPS = 10;
    public static final int DELAY = 500;
    String o;

    public static void main(String[] args) {
//        Object o = new int[1];
        String o = new String("asd");
        TestSyncBlock testSyncBlock1 = new TestSyncBlock(o);
        TestSyncBlock testSyncBlock2 = new TestSyncBlock(o);

        new Thread(testSyncBlock1::methodA, "A").start();
        new Thread(testSyncBlock2::methodB, "B").start();
    }

    public TestSyncBlock(String o) {
        this.o = o;
    }

    private void methodA() {
        o += "123";
//        synchronized (TestSyncBlock.class) {
        synchronized (o) {
            System.out.println("Start A");

            for (int i = 0; i < STEPS; i++) {
                System.out.print(Thread.currentThread().getName()+":" + i + " ");
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("End A");
        }
    }

    private void methodB() {
        synchronized (o) {
            System.out.println("Start B");

            for (int i = 0; i < STEPS; i++) {
                System.out.print(Thread.currentThread().getName()+":" + i + " ");

                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("End B");
        }
    }
}
