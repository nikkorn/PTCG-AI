package output;

/**
 * Helper class for printing text to the console.
 */
public class TextPrinter {
	
	/**
	 * The padding positions for wrapping text.
	 */
	public enum PaddingPosition { LEFT, RIGHT, WRAP }

	/**
	 * Add whitespace padding to a string.
	 * @param value The string to append padding to.
	 * @param whitespace The expected string width.
	 * @param paddingPosition The position at which to add the padding.
	 * @return The padded string.
	 */
	public static String padString(String value, int whitespace, PaddingPosition paddingPosition) {
		String paddedValue = value + "";
		switch(paddingPosition) {
			case LEFT:
				// Apply padding to the start of the value.
				while (paddedValue.length() < whitespace) {
					paddedValue = " " + paddedValue;
				}
				break;
			case RIGHT:
				// Apply padding to the end of the value.
				while (paddedValue.length() < whitespace) {
					paddedValue += " ";
				}
				break;
			case WRAP:
				// Calculate how much padding to apply either side of the value.
				int margin = (whitespace - value.length()) / 2;
				// Add the padding either side of the value.
				for (int i = 0; i < margin; i++) {
					paddedValue = " " + paddedValue + " ";
				}
				// Are we still missing a space?
				if (paddedValue.length() < whitespace) {
					paddedValue += " ";
				}
				break;
		}
		return paddedValue;
	}
	
	/**
	 * Add whitespace padding to the right of a string.
	 * @param value The string to append padding to.
	 * @param whitespace The expected string width.
	 * @return The padded string.
	 */
	public static String padString(String value, int whitespace) {
		return padString(value, whitespace, PaddingPosition.RIGHT);
	}
}
