package collections.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumbersImpl implements NumberProblem {
    @Override
    public void showEvenNosInAscendingOrder(int[] numbers) {
        List<Integer> evens = new ArrayList<>();
        for(int n : numbers){
            if(n%2==0){
                evens.add(n);
            }
        }
        Collections.sort(evens);
        //evens.sort(Comparator.naturalOrder());
        evens.forEach(System.out::println);
    }

    @Override
    public void showOddNosInDesendingOrder(int[] numbers) {
        List<Integer> odds = new ArrayList<>();
        for(int n : numbers){
            if(n%2!=0){
                odds.add(n);
            }
        }
        odds.sort(Comparator.reverseOrder());
        /*
        Collections.sort(odds, (i, j) -> {
            if(j>i) return 1;
            else if(i>j)  return -1;
            else return 0;
        });
         */
        odds.forEach(System.out::println);
    }

    @Override
    public void showPrimeNosInAscendingOrder(int[] numbers) {
        List<Integer> primes = new ArrayList<>();
        for(int x: numbers){
            if(isPrime(x))
                primes.add(x);
        }
        Collections.sort(primes, (i, j) -> (i>j) ? 1 :(i<j)? -1 :0);

        /*
        Collections.sort(primes, (i, j) -> {
            if(i>j) return 1;
            else if(i<j)  return -1;
            else return 0;
        });
        */
        primes.forEach(System.out::println);
    }

    @Override
    public void showNonPrimeNosInDesendingOrder(int[] numbers) {
        List<Integer> consonants = new ArrayList<>();
        for(int x: numbers){
            if(!isPrime(x))
                consonants.add(x);
        }
        consonants.sort((i, j) -> j.compareTo(i));

        //Collections.sort(consonants, (i, j) -> j.compareTo(i));

        consonants.forEach(System.out::println);
    }

    public boolean isPrime(int n){
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            //for(int i=2; i<(n/2); i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 8, 4, 9, 10, 30, 7, 47, 49, 200};

        NumberProblem problem = new NumbersImpl();
        System.out.println("Even numbers in ascending order");
        problem.showEvenNosInAscendingOrder(numbers);

        System.out.println("Odd numbers in desending order");
        problem.showOddNosInDesendingOrder(numbers);

        System.out.println("Prime numbers in ascending order");
        problem.showPrimeNosInAscendingOrder(numbers);

        System.out.println("consonants numbers in desending order");
        problem.showNonPrimeNosInDesendingOrder(numbers);
    }
}