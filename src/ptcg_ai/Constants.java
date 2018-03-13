package ptcg_ai;

/**
 * Application constants.
 */
public class Constants {
	
	/** The path of the card library JSON file. */
	public static String CARD_LIBRARY_PATH = "./resources/card_library.json";
	
	/** The directory of card configuration files. */
	public static String DECK_CONFIG_DIR = "./decks/";
	
	/** The number of cards that a deck is made up of. */
	public static int DECK_REQUIRED_SIZE = 60;
	
	/** The number of duplicate cards allowed in a deck. */
	public static int DECK_DUPLICATES_ALLOWED = 4;
	
	/** The default number of cards in a hand. */
	public static int HAND_DEFAULT_SIZE = 7;
	
	/** The sleep in millis between coin flip animations. */
	public static long COIN_FLIP_ANIMATION_SLEEP = 200;

	/**
	 * PRINTING.
	 */
	
	/** Some ANSI codes for coloured console output. */
	public static final String PRINTING_ANSI_RESET   = "\u001B[0m";
	public static final String PRINTING_ANSI_BLACK   = "\u001B[30m";
	public static final String PRINTING_ANSI_RED     = "\u001B[31m";
	public static final String PRINTING_ANSI_GREEN   = "\u001B[32m";
	public static final String PRINTING_ANSI_YELLOW  = "\u001B[33m";
	public static final String PRINTING_ANSI_BLUE    = "\u001B[34m";
	public static final String PRINTING_ANSI_PURPLE  = "\u001B[35m";
	public static final String PRINTING_ANSI_WHITE   = "\u001B[37m";
	
	/** Damage tokens. */
	public static final String PRINTING_DAMAGE_TOKEN         = "\u2b1b";
	public static final String PRINTING_DAMAGE_TOKEN_EMPTY   = "\u2b1c";
}
