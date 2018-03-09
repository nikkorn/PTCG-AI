package ptcg_ai;

/**
 * Application constants.
 */
public class Constants {
	
	/** The path of the card library JSON file. */
	public static String CARD_LIBRARY_PATH = "./resources/card_library.json";
	
	/** The sleep in millis between coin flip animations. */
	public static long COIN_FLIP_ANIMATION_SLEEP = 200;

	/** Some ANSI codes for coloured console output. */
	public static final String ANSI_RESET   = "\u001B[0m";
	public static final String ANSI_BLACK   = "\u001B[30m";
	public static final String ANSI_RED     = "\u001B[31m";
	public static final String ANSI_GREEN   = "\u001B[32m";
	public static final String ANSI_YELLOW  = "\u001B[33m";
	public static final String ANSI_BLUE    = "\u001B[34m";
	public static final String ANSI_PURPLE  = "\u001B[35m";
	public static final String ANSI_WHITE   = "\u001B[37m";
}
