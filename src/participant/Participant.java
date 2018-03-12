package participant;

import match.TurnContext;
import match.Deck;
import match.Hand;
import pokemon.Pokemon;

/**
 * Represents a participant
 */
public abstract class Participant {
	/**
	 * The name of the participant.
	 */
	private String name;
	/**
	 * The participants active pokemon.
	 */
	private Pokemon activePokemon = null;
	/**
	 * The participants deck.
	 */
	private Deck deck = null;
	/**
	 * The participants hand.
	 */
	private Hand hand = null;
	
	/**
	 * Creates a new instance of the Participant class.
	 * @param name The name of the participant.
	 */
	public Participant(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the participant.
	 * @return The name of the participant.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the participants deck.
	 * @return The participants deck.
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * Set the participants deck.
	 * @param deck The participants deck.
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	/**
	 * Get the participants hand.
	 * @return The participants hand.
	 */
	public Hand getHand() {
		return hand;
	}

	/**
	 * Set the participants hand.
	 * @param hand The participants hand.
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	/**
	 * Gets the active pokemon.
	 * @return The active pokemon.
	 */
	public Pokemon getActivePokemon() {
		return activePokemon;
	}

	/**
	 * Sets the active pokemon.
	 * @param activePokemon The active pokemon.
	 */
	public void setActivePokemon(Pokemon activePokemon) {
		this.activePokemon = activePokemon;
	}
	
	/**
	 * Perform pre-turn activities.
	 */
	public void onPreTurn() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Called in response to it becoming the participant turn.
	 * @param context The turn context.
	 */
	public abstract void onTurn(TurnContext context);
	
	/**
	 * Perform post-turn activities.
	 */
	public void onPostTurn() {
		// TODO Auto-generated method stub
	}
}
