package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringSplit {

    public static void main(String[] args) {

        String address = "Sherlock Holmes Museum, 221B, Baker Street, Westminster, London, England, NW1.";

        String[] tokens = address.split("," );

        System.out.println("\n1. Display Address tokens :");

        for(String t : tokens){
            System.out.println(t);
        }

        StringTokenizer tokenizer = new StringTokenizer(address, ", ");

        List<String> addressTokens = new ArrayList<>();

        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            addressTokens.add(token);
        }

        System.out.println("\n2. Address tokens split by StringTokenizer:");
        addressTokens.forEach(System.out::println);

        List<String> strings = Pattern.compile(",").splitAsStream(address)
                .collect(Collectors.toList());

        System.out.println("\n3. Address tokens split by splitAsStream:");
        addressTokens.forEach(System.out::println);
    }
}
