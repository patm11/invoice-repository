package home.invoice.ra.utility;

/**
 * Utility that verifies given inputs can be cast to the specified data types
 *
 * @author patm11
 * Created on 4/13/20
 */
public class DataTypeUtils {

    private DataTypeUtils() {}

    /**
     * Determines if the given string can be converted to a long type
     *
     * @param string the string
     * @return the is long flag
     */
    public static boolean isLong(String string) {
        boolean isLong = true;

        try {
            Long.parseLong(string);
        } catch (NumberFormatException e) {
            isLong = false;
        }

        return isLong;
    }
}
