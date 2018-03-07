package participant;

import match.TurnContext;
import pokemon.Pokemon;

/**
 * Represents a participant
 */
public abstract class Participant {
	/**
	 * The deck configuration path for this participant.
	 */
	private String deckConfigurationPath;
	/**
	 * The participants active pokemon.
	 */
	private Pokemon activePokemon = null;
	
	/**
	 * Creates a new instance of the Participant class.
	 * @param deckConfigurationPath The path to the participants deck configuration.
	 */
	public Participant(String deckConfigurationPath) {
		this.deckConfigurationPath = deckConfigurationPath;
	}
	
	/**
	 * Gets the deck configuration path for this participant.
	 * @return The deck configuration path for this participant.
	 */
	public String getDeckConfigurationPath() {
		return this.deckConfigurationPath;
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
}
