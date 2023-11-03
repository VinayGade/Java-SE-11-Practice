package streams;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        Integer[] numbers = new Integer[10];

        int[] nums = new int[4];

        Optional<Integer> checkNull = Optional.ofNullable(numbers[1]);

        Optional<Integer> checkNull2 = Optional.ofNullable(nums[3]);

        int result = checkNull.isPresent() ? checkNull.get() : -1;

        System.out.println("**** isPresent ="+result);

        System.out.println("**** ifPresent");
        checkNull.ifPresent(System.out::println);

        //way 2
        //orElse : If a value is present, returns the value, otherwise returns other.
        int result2 = checkNull2.orElse(-1);

        System.out.println(result+ " "+result2);

        Integer[] nos = new Integer[3];

        nos[2] = 4;

        Optional<Integer> optionalNum = Optional.ofNullable(nos[2]);

        int result1 = optionalNum.orElse(-1);

        System.out.println("** result1 : orElse ="+result1);

        //orElseGet
        // If a value is present, returns the value,
        // otherwise returns the result produced by the supplying function.

        Optional<Integer> optionalInt = Optional.ofNullable(nos[1]);

        int resultNum = optionalInt.orElseGet(() -> -1);

        System.out.println("** result : orElseGet  ="+resultNum);

        /* orElseThrow:
        If a value is present, returns the value, otherwise throws NoSuchElementException.
        Returns: the non-null value described by this Optional
        Throws: NoSuchElementException – if no value is present
        Since: Java 10
        * */
        try{
            System.out.println("*** result : orElseThrow ");

            int throwableResult2 = optionalNum.orElseThrow(Exception::new);
            System.out.println("throwableResult2  ="+throwableResult2);

            int throwableResult1 = optionalInt.orElseThrow(NullPointerException::new);
            System.out.println("throwableResult1  ="+throwableResult1);

        }catch(Exception ex){
            ex.printStackTrace();
        }


        Optional<String> optionalStr = Optional.of("Java 8 Optional");

        try {
            Optional<String> optionalNull = Optional.of(null);

            //Note : Value must be provided with Optional.of method...
            System.out.println(optionalNull);
        }catch (NullPointerException npe){
            npe.printStackTrace();
        }

        System.out.println(optionalStr);

        System.out.println("Words :"+getWords());

        Optional<Integer> num = getNumber();

        num.ifPresent(System.out::println);

    }

    public static Optional<String> getWords(){
        String[] words = new String[4];

        //words[2] = "Vinay";

        Optional<String> word = Optional.ofNullable(words[2]); //value can be null

        if(word.isPresent())
            return word;
        else
            return Optional.empty();
    }

    public static Optional<Integer> getNumber(){
        Integer nums[] = new Integer[3];

        nums[2] = 105;
        Optional<Integer> num = Optional.ofNullable(nums[2]);

        return (num.isPresent()) ? num : Optional.empty();
    }
}
