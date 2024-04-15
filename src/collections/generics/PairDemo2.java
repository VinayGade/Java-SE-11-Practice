package collections.generics;

public class PairDemo2 {
    public static void main(String[] args) {
        ComparablePair<Integer> pair1 = new ComparablePair<>(100, 50);
        ComparablePair<Integer> pair2 = new ComparablePair<>(10, 500);

        System.out.println("pair1 largest = "+pair1.getLargest());
        System.out.println("pair2 largest = "+pair2.getLargest());
    }
}
