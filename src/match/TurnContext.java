package match;

import energy.Energy;
import moves.Move;
import participant.Participant;
import pokemon.Pokemon;

/**
 * Represents a single turn for a participant.
 */
public class TurnContext {
	/**
	 * The participant taking the turn and their opponent.
	 */
	private Participant participant, opponent;
	/**
	 * Whether the participant has already attached an Energy to a pokemon this turn.
	 */
	private boolean hasAttachedEnergy = false;
	/**
	 * Whether the participant has already attacked this turn.
	 */
	private boolean hasAttacked = false;
	
	/**
	 * Creates a new instance of the TurnContext class.
	 * @param participant The participant taking the turn.
	 * @param opponent The opponent of the participant taking the turn.
	 */
	public TurnContext(Participant participant, Participant opponent) {
		this.participant = participant;
		this.opponent    = opponent;
	}
	
	/**
	 * Get the participant taking the turn.
	 * @return The participant taking the turn.
	 */
	public Participant getParticipant() {
		return this.participant;
	}
	
	/**
	 * Get the opponent of the participant taking the turn.
	 * @return The opponent of the participant taking the turn.
	 */
	public Participant getOpponent() {
		return this.opponent;
	}
	
	/**
	 * Attaches an energy card to the target pokemon.
	 * This can only happen once a turn.
	 * @param target The target pokemon.
	 * @param energy The energy card to attach.
	 * @return Whether the action was a success.
	 */
	public boolean attachEnergyToPokemon(Pokemon target, Energy energy) {
		// We cannot do this if we have already attacked.
		if (this.hasAttacked) {
			System.out.println("Cannot attach energy cards to a pokemon after attacking!");
			return false;
		}
		// We can only do this once per turn.
		if (!this.hasAttachedEnergy) {
			// Attach the energy.
			target.getAttachedEnergyCards().add(energy);
			// Log that this has happened to the console.
			System.out.println("Attached " + energy.getEnergyType() + " to " + target.getName());
			// Set the flag which says we have attached our energy this turn.
			this.hasAttachedEnergy = true;
		}
		// We cannot do this twice per turn.
		// Log that this has happened to the console.
		System.out.println("Can only attach one energy card to a pokemon per turn!");
		return false;
	}
	
	/**
	 * Attack with the currently active pokemon.
	 * The target will be the opponents active pokemon.
	 * @param move The move to perform.
	 */
	public void attackWithPokemon(Move move) {
		// We cannot do this if we have already attacked.
		if (this.hasAttacked) {
			System.out.println("You can only attack once per turn!");
			return;
		}
		// Get the active pokemon.
		Pokemon activePokemon = this.participant.getActivePokemon();
		// Make sure we have an active pokemon.
		if (activePokemon == null) {
			System.out.println("There is no active pokemon!");
			return;
		}
		// This move has to belong to the active pokemon.
		if (!activePokemon.getMoves().contains(move)) {
			System.out.println("The active pokemon does not know the move: " + move.getName());
			return;
		}
		// The active pokemon must have the energy required to pay for the move.
		if (!move.getEnergyCost().isSatisfiedBy(activePokemon.getAttachedEnergyCards())) {
			System.out.println("The active pokemon does not have the required energy cards!");
			return;
		}
		// TODO Do the attack!
		System.out.println(activePokemon.getName() + " attacks with " + move.getName() + "!");
		// Set the flag which says we have attacked this turn.
		this.hasAttacked = true;
	}
}
