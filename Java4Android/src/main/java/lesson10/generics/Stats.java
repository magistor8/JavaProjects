package lesson10.generics;

public class Stats<E extends Number> {

        private E[] nums;

    public Stats(E... nums) {
        this.nums = nums;
    }

    private double avg() {
        double sum = 0;
        for (E num : nums) {
            sum += num.doubleValue();
        }
        return sum / nums.length;
    }


    private boolean isAvg( Stats<?> eStats) {
        return Math.abs(eStats.avg() - avg()) < 0.000001;
    }

    public static void main(String[] args) {
        Stats<Integer> ints = new Stats<>(1, 2, 3, 4, 5, 6);
        Stats<Double> doubleStats = new Stats<>(1.5, 3.2, 4.0, 6.0, 3.3, 3.0);

        System.out.println("avg int: " + ints.avg());
        System.out.println("avg double: " + doubleStats.avg());
        System.out.println("avg vs avg: " + ints.isAvg(doubleStats));
    }
}

