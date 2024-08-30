package wissen;
import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) throws Exception {
        Object[] array = { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 };

        List<Integer> flattenedArray = flatten(array);

        System.out.println(flattenedArray);
    }

    public static List<Integer>  flatten(Object[] arr) throws Exception {

        List<Integer> result = new ArrayList<>();

        for(int i=0; i< arr.length; i++){
            if(arr[i] instanceof Integer)
                result.add((Integer)arr[i]);
            else{
                //int j = 0;
                result.addAll(flatten((Object[])arr[i]));
                //Integer[] sublist = flatten((Object[])arr[i]);
                //result.addAll(Arrays.asList(sublist));
                //for(; j< arr[i].length; j++){
            }
        }
        return result;
        //return (Integer[])result.stream().mapToInt(Integer::intValue).toArray();


        /*
        List<Integer> nums =
                arr.stream()
                        .filter((x) -> (x instanceOf Integer))
	        .flatMap(x -> )
                .collect(Collectors.toList());

        return null;
         */
    }
}
