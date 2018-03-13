package card;

import energy.Energy;
import pokemon.Pokemon;
import trainer.Trainer;

/**
 * Prints card info to the console.
 */
public class CardPrinter {
	
	/**
	 * Print card info to the console.
	 * @param card The card to print.
	 */
	public static void print(ICard card) {
		switch(card.getType()) {
		case ENERGY:
			CardPrinter.printEnergy((Energy)card);
			break;
		case POKEMON:
			CardPrinter.printPokemon((Pokemon)card);
			break;
		case TRAINER:
			CardPrinter.printTrainer((Trainer)card);
			break;
		}
	}
	
	private static void printEnergy(Energy energy) {
		
	}
	
	private static void printPokemon(Pokemon pokemon) {
		
	}
	
	private static void printTrainer(Trainer energy) {
		
	}
}
