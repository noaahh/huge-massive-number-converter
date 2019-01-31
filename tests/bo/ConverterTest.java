package bo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ConverterTest {

	/**
	 * They represent all the same number in different numbersystems/bases.
	 */
	private final static String BASE_2  = "10000010100100010111000100101010000010101000111110101101000000011010101111011101110011101101011100001111110110101110111011011010111010101010000111000000000011010101111111101011111011";
	private final static String BASE_3  = "1021020121121022211212000120111212211200021002001021002022001021120201022022100112200100010101001100220012102101122";
	private final static String BASE_7  = "23641143265612333021005626400451465255313213011044440136420445100";
	private final static String BASE_8  = "2024427045202507655003257356355341766567332725207000325775373";
	private final static String BASE_10 = "3126485650002806059265235559620383787531710118313327355";
	private final static String BASE_16 = "20a45c4a82a3eb406af773b5c3f6bbb6BAA8700357FAFB";
	private final static String BASE_36 = "1234567890abcdefghijklmnopqrSTUvwxyz";
	private final static String BASE_47 = "9y5cHgrwpFbhBnuCyJaed5wnfyCxcebJB";
	private final static String BASE_62 = "5hRJZ7sB3CagH23u91NST5lMBb9JIlJ";
	private final static String BASE_64 = "CCkXEqCo+tAavdztcP2u7a6qHADV/r7";
	
	private static LinkedHashMap<Integer, String> BASES = new LinkedHashMap<>(6);
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		BASES.put(2,  BASE_2 );
		BASES.put(3,  BASE_3 );
		BASES.put(7,  BASE_7 );
		BASES.put(8,  BASE_8 );
		BASES.put(10, BASE_10);
		BASES.put(16, BASE_16);
		BASES.put(36, BASE_36);
		BASES.put(47, BASE_47);
		BASES.put(62, BASE_62);
		BASES.put(64, BASE_64);
	}
	
	@Test
	void validateBaseString() {
		for (Integer base: BASES.keySet()) {
			 assertTrue(BASES.get(base).matches(getValidationRegexRange(base)));
		}
	}
	
	@Test
	public void validateBaseConversation() {
		for (Integer baseX: BASES.keySet()) {
			for (Integer baseY : BASES.keySet()) {
				String y = BASES.get(baseY);
				if (baseY <= 36) y = y.toLowerCase();
				assertEquals(y, Converter.convert(BASES.get(baseX), baseX, baseY), "base" + baseX +" to base" + baseY + " failed");
			}
		}
	}
	
	private static String getValidationRegexRange(int base) {
		if (base > 36 || base < 2) return "";

		String numRange = "0-" + (base >= 10 ? "9" : (base - 1));
		String charRange = base > 10 ? charRange = "a-" + ((char) (base - 11 + 'a')) : "";
		return "[" + numRange + charRange + charRange.toUpperCase() + "]+";
	}

}
