package date_time_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeConversion {

    // Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
   // eg. '12:01:00PM' returns '12:01:00'.

    // eg. '12:01:00AM' returns '00:01:00'.
    public static String convertMilitary(String input) throws ParseException {
        // Format of the date defined in the input String
        var dateFormat
                = new SimpleDateFormat("hh:mm:ssaa");

        // Change the pattern into 24 hour format
        var format
                = new SimpleDateFormat("HH:mm:ss");
        Date time ;
        String output;

        // Converting the input String to Date
        time = dateFormat.parse(input);

        // Changing the format of date
        // and storing it in
        // String
        output = format.format(time);
        return output;
    }
    
    // Given a time in military (24-hour), convert it to 12-hour AM/PM time format.
    public static String convert12Hour(String time){

        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss"))
                .format(DateTimeFormatter.ofPattern("hh:mm:ss AA"));
        /*
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            final Date dateObj = sdf.parse(time);
            time = new SimpleDateFormat("hh:mm aa").format(dateObj);
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return time;
         */
    }

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String result = convertMilitary(s);
        System.out.println("Military time : "+result);
        System.out.println("\n12-hour AM/PM time :"+convert12Hour(result));
    }
}
