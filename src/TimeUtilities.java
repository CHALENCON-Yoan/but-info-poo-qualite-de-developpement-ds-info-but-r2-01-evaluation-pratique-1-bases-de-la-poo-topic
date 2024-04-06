/**
 * Time-related constants and utility methods.
 */
public class TimeUtilities {

    /**
     * Number of seconds in a minute.
     */
    public final static int SECONDS_IN_A_MINUTE = 60;

    /**
     * Number of seconds in an hour.
     */
    public final static int SECONDS_IN_AN_HOUR = 3600;

    /**
     * Number of minutes in an hour.
     */
    public final static int MINUTES_IN_AN_HOUR = 60;

    /**
     * Number of minutes in a day.
     */
    public final static int MINUTES_IN_A_DAY = 1440;

    /**
     * Number of hours in a day.
     */
    public final static int HOURS_IN_A_DAY = 24;

    /**
     * Noon (mid-day) time, in seconds from midnight.
     */
    public final static int NOON_TIME = 12 * SECONDS_IN_AN_HOUR;

    /**
     * Formats a time (in seconds from midnight) as a string like "08:23:45".
     * @param time time to format (in seconds from midnight).
     * @return formatted string like "08:23:45".
     */
    public static String timeToString(int time) {
        int hour = time / SECONDS_IN_AN_HOUR;
        int remaining = time % SECONDS_IN_AN_HOUR;
        int minute = remaining / SECONDS_IN_A_MINUTE;
        int second = remaining % SECONDS_IN_A_MINUTE;
        String result = "";
        if (hour < 10) result += "0";
        result += hour;
        result += ":";
        if (minute < 10) result += "0";
        result += minute;
        result += ":";
        if (second < 10) result += "0";
        result += second;
        return result;
    }

    /**
     * Converts a string like "08:23:45" into a time (in seconds from midnight).
     * @param timeString string to convert, like "08:23:45".
     * @return time (in seconds from midnight).
     */
    public static int stringToTime(String timeString) {
        String[] tokens = timeString.split(":");
        int hour = Integer.parseInt(tokens[0]);
        int minute = Integer.parseInt(tokens[1]);
        int second = Integer.parseInt(tokens[2]);
        return (((hour * MINUTES_IN_AN_HOUR) + minute) * SECONDS_IN_A_MINUTE) + second;
    }
}
