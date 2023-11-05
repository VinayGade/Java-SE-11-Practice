package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IteratingStreams {

    public static void main(String[] args) {

        System.out.println("First 10 even numbers");
        Stream.iterate(0, x -> x+2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("\nFirst 10 odd numbers");
        Stream.iterate(0, n -> n + 1)
                .filter(x -> x % 2 != 0) //odd
                .limit(10)
                .forEach(x -> System.out.print(" "+x));

        System.out.println("\nFibonacci Series first 20 terms");
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0]+n[1]})
                .limit(20)
                .map(n -> n[0])
                .forEach(x -> System.out.print(" "+x));

        int sum = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(n -> n[0]) // Stream<Integer>
                .mapToInt(n -> n)
                .sum();

        System.out.println("\nFibonacci 10 sum : " + sum);

        System.out.println("Power of 2 first 10 terms:");

        Stream.iterate(1, n-> n*2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Power of 2 <= 200:");   // Java 9

        Stream.iterate(1, n -> n<=200, n -> n*2)
                .forEach(x -> System.out.print(" "+x));

        // Stream concat
        Stream<Integer> firstStream = Stream.of(1, 2, 3);
        Stream<Integer> secondStream = Stream.of(4, 5, 6);

        System.out.println("\n result = Stream.concat(firstStream, secondStream)");
        Stream<Integer> resultingStream = Stream.concat(firstStream, secondStream);

        System.out.println( resultingStream.collect(Collectors.toList()) );

        Stream<Integer> first = Stream.of(1, 2);
        Stream<Integer> second = Stream.of(3,4);
        Stream<Integer> third = Stream.of(5, 6);
        Stream<Integer> fourth = Stream.of(7,8);

        System.out.println("\n result = Stream.concat(first, Stream.concat(second, Stream.concat(third, fourth)))");

        Stream<Integer> resultingStream2 = Stream.concat(first,
                Stream.concat(second,
                        Stream.concat(third, fourth)));

        System.out.println( resultingStream2.collect(Collectors.toList()) );

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> stream2 = Stream.of(4, 5, 6, 7, 8, 9);

        Stream<Integer> resultingStream3 = Stream.concat(stream1, stream2)
                .distinct();

        System.out.println("\n result = distinct (stream1, stream2)");
        System.out.println( resultingStream3.collect(Collectors.toList()) );

        System.out.println("Using forEachOrdered output is ordered...");

        List<String> list = Arrays.asList("B", "A", "C", "D", "F");
        list.stream().parallel().forEachOrdered(e -> System.out.print(" "+e));

        System.out.println("\nUsing forEach output is unordered in case of parallel streams");

        list.stream().parallel().forEach(e -> System.out.print(" "+e));

        System.out.println("\nUsing forEach output with sorted");

        list.stream().sorted().forEach(e -> System.out.print(" "+e));

        System.out.println("\nPrint table of 10 unordered");

        IntStream.range(1, 200).parallel().filter(i -> i % 10 == 0).forEach(e->System.out.print(" "+e));

        System.out.println("\nPrint table of 10 unordered");

        IntStream.range(1, 200).unordered().parallel().filter(i -> i % 10 == 0)
                    .forEach(e->System.out.print(" "+e));

        //forEachOrdered
        System.out.println("\nPrint table of 10 ordered : forEachOrdered");

        IntStream.range(1, 200).parallel().filter(i -> i % 10 == 0)
                .forEachOrdered(e->System.out.print(" "+e));

        List<String> flatNumbers = List.of("A13", "B21", "D22",
                "a02", "E32", "C32",
                "C22", "b13", "A32",
                "d03", "c11", "D31", "A33", "e01");

        System.out.println("\nFlats in D wing :");

        flatNumbers.stream()
                .filter(flat -> (flat.startsWith("D") || flat.startsWith("d")))
                .forEach(System.out::println);

        System.out.println("\nFlats in A wing (Case insensitive):");

        List<String> flatsA = flatNumbers.stream()
                .map(String::toUpperCase)  //.map(flat -> flat.toUpperCase())
                .filter(flat -> flat.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());

        flatsA.forEach(System.out::println);

        System.out.println("\n Concatenate 2 streams :");
        Stream<Integer> numbers1 = Stream.of(10, 20 ,30, 40, 50, 60, 80, 100);
        Stream<Integer> numbers2 = Stream.of(5, 10, 15, 20, 25, 45, 75, 80);

        //System.out.println("numbers1 count ="+numbers1.count());
        //System.out.println("numbers2 count ="+numbers2.count());
        Stream<Integer> combined = Stream.concat(numbers1, numbers2).sorted();
        //System.out.println("combined count ="+combined.count());
        // System.out.println("combined distinct count ="+combined.distinct().count());
        combined.forEach( n-> System.out.print(" "+n));
        /*
        System.out.println("combined distinct peek element =");
        combined.distinct().peek(System.out::println);
         */
    }
}