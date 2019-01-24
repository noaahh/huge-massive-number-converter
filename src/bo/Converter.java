package bo;

import java.math.BigInteger;

/**
 * A class which currently only contains one method for converting a number to a
 * number with an other radix.
 * 
 * @author Florin Barbisch
 *
 */
public class Converter {
	
	/**
	 * Converts a String with a specific radix to another number with a specific
	 * radix. Returns {@code null} if one of both radix are not inside the range
	 * from {@link Character#MIN_RADIX} to {@link Character#MAX_RADIX} inclusive, or
	 * value is not a valid representation of a {@link BigInteger}.
	 * 
	 * @param value       A {@link String} representing a {@link BigInteger}
	 * @param inputRadix  The radix of the input value
	 * @param outputRadix The radix of the output value
	 * @return {@link String} representation of the given value (and it's given
	 *         radix) in the given radix.
	 * 
	 * @see {@link BigInteger#BigInteger(String, int)}
	 * @see {@link BigInteger#toString(int)}
	 */
	public static String convert(String value, int inputRadix, int outputRadix){
		if (inputRadix < Character.MIN_RADIX || inputRadix > Character.MAX_RADIX || outputRadix < Character.MIN_RADIX || outputRadix > Character.MAX_RADIX) {
			return null;
		}
		
		try {
			return new BigInteger(value, inputRadix).toString(outputRadix);
        } catch (NumberFormatException e) { return null; }
    }
}