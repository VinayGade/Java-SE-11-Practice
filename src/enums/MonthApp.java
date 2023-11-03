package enums;

import beans.enums.Month;

import java.util.Scanner;

public class MonthApp {

    public static void main(String[] args) {

        // display index of month
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a valid month:");
        String choice = scanner.next();

        choice = choice.toUpperCase();

        Month selectedMonth = Month.APRIL;

        for(Month month: Month.values()) {

            if(month.name().equals(choice)) {
                selectedMonth = month;
                break;
            }
        }

        System.out.println(" month ="+selectedMonth.name()+", index = " +(selectedMonth.getIndex() ));

        switch(selectedMonth){
            case APRIL:
                System.out.println(" April is " +(selectedMonth.getIndex()+1) +"th Month" );
                break;

            case MAY:
                System.out.println(" MAY is " +(selectedMonth.getIndex()+1) +"th Month" );
                break;

            case JANUARY:
                System.out.println(" JANUARY is " +(selectedMonth.getIndex()+1) +"th Month" );
                break;
            case JULY:
                System.out.println(" JULY is " +(selectedMonth.getIndex()+1) +"th Month" );
                break;

            case JUNE:
                System.out.println(" JUNE is " +(selectedMonth.getIndex()+1) +"th Month" );
                break;

            case MARCH:
                System.out.println(" MARCH is " +(selectedMonth.getIndex()+1) +"th Month" );
                break;

            case FEBRUARY:
                System.out.println(" FEBRUARY is " +(selectedMonth.getIndex()+1) +"th Month" );
                break;

            case AUGUST:
                System.out.println(" AUGUST is " +(selectedMonth.getIndex()+1) +"th Month" );
                break;

            case SEPTEMBER:
                System.out.println(" SEPTEMBER is " +(selectedMonth.getIndex()+1) +"th Month" );
                break;

            case OCTOBER:
                System.out.println(" OCTOBER is " +(selectedMonth.getIndex()+1) +"th Month" );
                break;

            case NOVEMBER:
                System.out.println(" NOVEMBER is " +(selectedMonth.getIndex()+1) +"th Month" );
                break;

            case DECEMBER:
                System.out.println(" DECEMBER is " +(selectedMonth.getIndex()+1) +"th Month" );
                break;
        }

    }
}
