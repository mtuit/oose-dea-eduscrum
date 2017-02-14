package nl.ica.oose.dea;

/**
 * Created by Mick on 13/02/2017.
 */
public class LeapYear {

    public static boolean isLeapYear(int year) {
        return isDivisible(year, 4) && (!isDivisible(year, 100) || isDivisible(year, 400));
    }

    private static boolean isDivisible(int leapYear, int denominator) {
        return leapYear % denominator == 0;
    }
}
