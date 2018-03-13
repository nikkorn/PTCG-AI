package ptcg_ai;

import java.util.ArrayList;
import card.ICard;
import match.Coin;

/**
 * Prints game state to the console.
 */
public class GamePrinter {

	/**
	 * Print help information to the console.
	 */
	public static void printHelp() {
		System.out.println("################################# HELP ##################################");
		System.out.println("#########################################################################");
		System.out.println("# CHECK [hand|1-6]      Checks the specified target. Either the hand    #");
		System.out.println("#                       of the player or a pokemon index (1=active,     #");
		System.out.println("#                       2-6=benched).                                   #");
		System.out.println("# PLAY index            Plays the card with the specified hand index.   #");
		System.out.println("# RETREAT index         Retreat the active pokemon, paying the retreat  #");
		System.out.println("#                       cost for the active pokemon and swapping it     #");
		System.out.println("#                       for the pokemon at the specified bench index.   #");
		System.out.println("# ATTACK move           Attacks with the specified move.                #");
		System.out.println("# POKEPOWER 1-6         Triggers a pokepower for pokemon at the         #");
		System.out.println("#                       specified index (1=active, 2-6=benched).        #");
		System.out.println("# END TURN              End the turn.                                   #");
		System.out.println("#########################################################################");
		System.out.println();
	}

	/**
	 * Print the input cursor.
	 */
	public static void printInputCursor() {
		System.out.print("> ");
	}

	/**
	 * Print a coin flip to the console.
	 * @param result
	 *            The result of the toss.
	 */
	public static void printCoinFlip(Coin.FlipResult result) {
		try {
			System.out.print(".");
			Thread.sleep(Constants.COIN_FLIP_ANIMATION_SLEEP);
			System.out.print(".");
			Thread.sleep(Constants.COIN_FLIP_ANIMATION_SLEEP);
			System.out.print(".");
			Thread.sleep(Constants.COIN_FLIP_ANIMATION_SLEEP);
			System.out.print(".");
			Thread.sleep(Constants.COIN_FLIP_ANIMATION_SLEEP);
			System.out.print(".");
			Thread.sleep(Constants.COIN_FLIP_ANIMATION_SLEEP);
			System.out.print(".");
			System.out.print(result == Coin.FlipResult.HEADS ? " (H) Heads!" : " (T) Tails!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Print hand information to the console.
	 * @param hand
	 *            The hand to print.
	 */
	public static void printHand(ArrayList<ICard> hand) {
		int cardIndex = 1;
		System.out.println("################## HAND ###################");
		System.out.println("###########################################");
		for (ICard card : hand) {
			System.out.println("# " + padString(cardIndex++ + ". " + card.getName(), 39) + " #");
		}
		System.out.println("###########################################");
		System.out.println();
	}

	/**
	 * Print a pokemon HP bar.
	 * @param hp
	 *            The number of damage tokens on the pokemon.
	 * @param total
	 *            The total hp of the pokemon.
	 */
	public static void printHPBar(int tokens, int total) {
		System.out.print("HP:");
		for (int i = 0; i < total; i++) {
			System.out.print(i < tokens ? Constants.PRINTING_DAMAGE_TOKEN : Constants.PRINTING_DAMAGE_TOKEN_EMPTY);
		}
	}

	/**
	 * Add whitespace padding to the end of a string.
	 * @param value
	 *            The string to append padding to.
	 * @param whitespace
	 *            The expected string width.
	 * @return The padded string.
	 */
	public static String padString(String value, int whitespace) {
		String paddedValue = value + "";
		while (paddedValue.length() < whitespace) {
			paddedValue += " ";
		}
		return paddedValue;
	}
}
