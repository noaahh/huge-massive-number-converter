package bo;

public class Converter {
	public static String convert(String value, int inputDigits, int outputDigits){
        try {
            return Long.toString(Long.parseLong(value, inputDigits), outputDigits);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
