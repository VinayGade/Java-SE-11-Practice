package date_time_api.baeldung;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeBasics {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        LocalDate date = LocalDate.of(2015, 02, 20);
        LocalDate someDay = LocalDate.parse("2015-02-20");

        // "20-02-2015"  ... Text '20-02-2015' could not be parsed

        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM/dd/yyyy");

        someDay.format(formatter);

        System.out.println("today is"+today+", "+today.getDayOfWeek());
        System.out.println("7 years ago"+someDay+", "+someDay.getDayOfWeek()+", month was "+someDay.getMonth());

        System.out.println("7 years ago some day was"+date+", "+date.getDayOfWeek()+", month was "+date.getMonth());

        LocalDate anotherDay = LocalDate.of(2016, 8, 23);
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(anotherDay));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(anotherDay));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(anotherDay));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(anotherDay));

        var someDate = DateTimeFormatter.RFC_1123_DATE_TIME.format(LocalDate
                .of(2018, 3, 9)
                .atStartOfDay(ZoneId.of("UTC-3")));

        System.out.println(someDate);

        System.out.println("Zoned Date Time");

        LocalDate anotherSummerDay = LocalDate.of(2016, 8, 23);
        LocalTime anotherTime = LocalTime.of(13, 12, 45);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(anotherSummerDay, anotherTime, ZoneId.of("Europe/Helsinki"));
        System.out.println(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                        .format(zonedDateTime));
        System.out.println(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)
                        .format(zonedDateTime));
        System.out.println(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                        .format(zonedDateTime));
        System.out.println(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                        .format(zonedDateTime));

        String timeColonPattern = "HH:mm:ss SSS";
        DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(timeColonPattern);
        LocalTime colonTime = LocalTime.of(17, 35, 50).plus(329, ChronoUnit.MILLIS);
        System.out.println(timeColonFormatter.format(colonTime));

        String timeColonPattern1 = "hh:mm:ss a";
        DateTimeFormatter timeColonFormatter1 = DateTimeFormatter.ofPattern(timeColonPattern1);
        LocalTime colonTime1 = LocalTime.of(17, 35, 50);
        System.out.println(timeColonFormatter1.format(colonTime1));
        
        /*
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        System.out.println(LocalTime.from(timeFormatter.parse("12:25:30 AM"))
                .isBefore(LocalTime.NOON));
         */

        /*@TODO
         * line 74: Exception in thread "main" java.time.format.DateTimeParseException: Text '12:25:30 AM' could not be parsed at index 9
         * This code is not working due to Date time format not getting parsed
         * need to be fixed
         * */

    }
}
