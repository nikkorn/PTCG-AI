package match;

import java.util.ArrayList;
import card.CardType;
import card.ICard;
import pokemon.Pokemon;

/**
 * Represents the hand of a participant.
 */
public class Hand extends ArrayList<ICard> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create a new instance of the Hand class.
	 * @param cards The initial cards in the hand.
	 */
	public Hand(ArrayList<ICard> cards) {
		this.addAll(cards);
	}
	
	/**
	 * Gets whether there are any basic pokemon in this hand.
	 * @return Whether there are any basic pokemon in this hand.
	 */
	public boolean containsBasicPokemon() {
		for (ICard card : this) {
			// Is this card a pokemon card with no pre-evolution?
			if(card.getType() == CardType.POKEMON && ((Pokemon)card).getPreEvolution() == null) {
				return true;
			}
		}
		// There were no basic pokemon in this hand.
		return false;
	}
}
