package bo;

import java.math.BigInteger;

/**
 * A class which contains methods for converting a number to a number with
 * another radix.
 * 
 * @author Florin Barbisch
 *
 */
public class Converter {
	
	/**
	 * Converts a {@link String} representing a number with a specific radix to
	 * another {@link String} representing a number with another radix. Returns
	 * {@code null} if one of both radix are not inside the range from 2 to 65536
	 * inclusive, or an {@link NumberFormatException} occurs.
	 * 
	 * @param value       A {@link String} representing a {@link BigInteger}
	 * @param inputRadix  The radix of the input number
	 * @param outputRadix The radix of the output number
	 * @return {@link String} representation of the given value (and it's given
	 *         radix) in the given radix.
	 * 
	 * @see #convertFrom(String, int)
	 * @see #convertTo(BigInteger, int)
	 */
	public static String convert(String value, int inputRadix, int outputRadix){
		if (inputRadix < 2 || inputRadix > 65_536 || outputRadix < 2 || outputRadix > 65_536) {
			return null;
		}
		
		try {
			return convertTo(convertFrom(value, inputRadix), outputRadix);
        } catch (NumberFormatException e) { return null; }
    }

	/**
	 * Converts a {@link BigInteger} with a radix to a {@link String}, the radix
	 * should be between 2 and 65536.
	 */
	public static String convertTo(BigInteger value, int radix) {
		StringBuilder sb = new StringBuilder();
		BigInteger base = BigInteger.valueOf(radix);
		
		while (!value.equals(BigInteger.ZERO)) {
			BigInteger[] dividerAndRemainder = value.divideAndRemainder(base);
			value = dividerAndRemainder[0];
			sb.append(intToChar(dividerAndRemainder[1].intValue(), radix));
		}
		return sb.reverse().toString();
	}
	
	/**
	 * Converts a {@link String} with a radix to a {@link BigInteger}, the radix
	 * should be between 2 and 65536.
	 */
	public static BigInteger convertFrom(String value, int radix) {
		char[] chars = value.toCharArray();
		final int charsMaxIndex = chars.length - 1;
		
		BigInteger bigInt = BigInteger.ZERO;
		BigInteger base   = BigInteger.valueOf(radix);
		
		for (int i = charsMaxIndex; i >= 0; i--) {
			bigInt = bigInt.add(BigInteger.valueOf(charToInt(chars[i], radix)).multiply(base.pow(charsMaxIndex - i)));
		}

		return bigInt;
	}
	
	private static int charToInt(char ch, int radix) {
		if (radix <= 36) {
			if (ch <= '9') return ch - '0';
			return (ch <= 'Z' ? ch - 'A' : ch - 'a') + 10;
		} else if (radix <= 62) {
			if (ch <= '9') return ch - '0';
			return ch <= 'Z' ? ch - 'A' + 36 : ch - 'a' + 10;
		} else if (radix <= 64) {
			if (ch == '+') {
				return 62;
			} else if (ch == '/') {
				return 63;
			} else if (ch <= '9') {
				return ch - '0' + 52;
			} else {
				return ch <= 'Z' ? ch - 'A' : ch - 'a' + 26;
			}
		} else {
			return ch;
		}
	}
	
	private static char intToChar(int ch, int radix) {
		if (radix <= 36) {
			if (ch <= 9) return (char) (ch + '0');
			return (char) (ch + 'a' - 10);
		} else if (radix <= 62) {
			if (ch <= 9) return (char) (ch + '0');
			return (char) (ch <= 36 ? ch + 'a' - 10  : ch + 'A' - 36);
		} else if (radix <= 64) {
			if (ch == 62) {
				return '+';
			} else if (ch == 63) {
				return '/';
			} else if (ch >= 52) {
				return (char) (ch - 52 + '0');
			} else {
				return (char) (ch <= 25 ? ch + 'A' : ch + 'a' - 26);
			}
		} else {
			return (char) ch;
		}
	}
}