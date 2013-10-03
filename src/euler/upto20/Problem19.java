package euler.upto20;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Problem19
 * <pre>
 * You are given the following information, but you may prefer to do some research for yourself.
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 *  Saving February alone,
 *  Which has twenty-eight, rain or shine.
 *  And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * </pre>
 * Brute force works: count = 171
 * User: MOD
 * Date: Nov 24, 2008
 * Time: 1:40:31 PM
 */
public class Problem19 {
    public static void main(String[] args) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
            Date beg = dateFormat.parse("1901-Jan-01");
            Date end = dateFormat.parse("2000-Dec-31");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(beg);
            int count = 0;
            while (beg.before(end)) {
                if ((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) && (calendar.get(Calendar.DAY_OF_MONTH) == 1)) {
                    ++count;
                }
                calendar.add(Calendar.DATE, 1);
                beg = calendar.getTime();
            }

            System.out.println("count = " + count);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
