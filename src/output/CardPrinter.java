package output;

import card.CardLibrary;
import card.ICard;
import energy.Energy;
import output.TextPrinter.PaddingPosition;
import pokemon.Pokemon;
import trainer.Trainer;

/**
 * Prints card info to the console.
 */
public class CardPrinter {
	
	/**
	 * Print card info to the console.
	 * @param card The name of the card to print.
	 */
	public static void print(String name, boolean showFullCard) {
		try {
			// Get the card.
			ICard card = CardLibrary.createCard(name);
			// Print the card.
			print(card, showFullCard);
		} catch (RuntimeException ex) {
			System.out.println("Could not print card '" + name + "' as it could not be found.");
			System.out.println();
		}
	}
	
	/**
	 * Print card info to the console.
	 * @param card The card to print.
	 */
	public static void print(ICard card, boolean showFullCard) {
		// check whether we were actually given a card.
		if (card == null) {
			System.out.println("Cannot print card!");
			System.out.println();
			return;
		}
		switch(card.getType()) {
		case ENERGY:
			CardPrinter.printEnergy((Energy)card);
			break;
		case POKEMON:
			CardPrinter.printPokemon((Pokemon)card, showFullCard);
			break;
		case TRAINER:
			CardPrinter.printTrainer((Trainer)card, showFullCard);
			break;
		}
	}
	
	/**
	 * Print a view of an Energy card to the console.
	 * @param energy The energy card
	 */
	private static void printEnergy(Energy energy) {
		System.out.println("###########################################");
		System.out.println("#                  ENERGY                 #");
		System.out.println("###########################################");
		System.out.println("# " + TextPrinter.padString(energy.getEnergyType().toString(), 39, PaddingPosition.WRAP) + " #");
		System.out.println("###########################################");
		System.out.println();
	}
	
	/**
	 * Print a view of a Pokemon card to the console.
	 * @param pokemon The pokemon card.
	 * @param showFullCard Whether to show the full card.
	 */
	private static void printPokemon(Pokemon pokemon, boolean showFullCard) {
		
	}
	
	/**
	 * Print a view of a Trainer card to the console.
	 * @param trainer The trainer card.
	 * @param showFullCard Whether to show the full card.
	 */
	private static void printTrainer(Trainer trainer, boolean showFullCard) {
		
	}
}
