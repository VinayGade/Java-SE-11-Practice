package collections.generics;

public class ComparablePair<T extends Comparable<T>>{
    private final T first;
    private final T second;

    public ComparablePair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public T getLargest(){
        return (first.compareTo(second) > 0) ? first : second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
