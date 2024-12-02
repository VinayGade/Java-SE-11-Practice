package basics;

import java.util.List;
import java.util.stream.Collectors;

public class String11 {

    // Java 6
    private static boolean isBlankString(String string) {
        return string == null || string.trim().isEmpty();
    }

    public static void main(String[] args) {

        String multilineString = "Baeldung helps \n \n developers \n explore Java.";

        // Java 11
        /*
        Stream<String>	lines()
        Returns a stream of lines extracted from this string, separated by line terminators.
        * */
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());

        lines.forEach(System.out::println);

        String s = "GeeksForGeeks\nGeeksForGeeks";
        List<String> result = s.lines().collect(Collectors.toList());

        System.out.println(result);

        String str = "";
        String str2 = "     ";

        // String isBlank, isEmpty : difference
        // Java 6
        boolean isBlankStr = isBlankString(str);
        boolean isBlankStr2 = isBlankString(str2);

        System.out.println("str isBlank ? "+isBlankStr+", str2 isBlank ? "+isBlankStr2);
        System.out.println("\nstr isEmpty ? "+str.isEmpty()+", str2 isEmpty ? "+str2.isEmpty());

        // Java 11
        System.out.println("\nstr isBlank ? "+str.isBlank()+
                "\n str2 isBlank ? "+str2.isBlank());

        //string may contain leading (& |) trailing white spaces

        String name1 = "  Vinay Gade";
        String name2 = "  Ganesh More   ";
        String name3 = "Ketan Kambale      ";
        String name4 = "    Vivek Botla   ";
        String name5 = "       Rahul Mandlik   ";

        System.out.println("\n***** Before strip strings are\n");
        System.out.println("name1:"+name1+", length="+name1.length());
        System.out.println("name2:"+name2+", length="+name2.length());
        System.out.println("name3:"+name3+", length="+name3.length());
        System.out.println("name4:"+name4+", length="+name4.length());
        System.out.println("name5:"+name5+", length="+name5.length());

        System.out.println("\n\n***** After strip strings are\n");

        System.out.println("name1 . strip leading:"+name1.stripLeading());
        System.out.println("name2 . strip Trailing:"+name2.stripTrailing());
        System.out.println("name3 . strip:"+name3.strip());
        System.out.println("name4 . strip:"+name4.strip());
        System.out.println("name5 . strip leading:"+name5.stripLeading());
    }
}
