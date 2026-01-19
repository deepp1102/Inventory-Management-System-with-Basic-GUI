package util;

public class ValidationUtil {

    public static boolean isValid(String name, String price, String qty) {
        try {
            if (name.isEmpty()) return false;
            double p = Double.parseDouble(price);
            int q = Integer.parseInt(qty);
            return p >= 0 && q >= 0;
        } catch (Exception e) {
            return false;
        }
    }
}