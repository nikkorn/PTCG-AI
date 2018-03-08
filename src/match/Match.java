package match;

import java.util.Random;
import participant.Participant;

/**
 * Represents a single match.
 */
public class Match {
	/**
	 * The match participants.
	 */
	private Participant participantA, participantB;
	/**
	 * The active participant.
	 */
	private Participant activeParticipant = null;
	/**
	 * The RNG to use for coin flips and deck shuffles.
	 */
	private Random rng;
	
	/**
	 * Creates an instance of the Match class.
	 * @param participantA The first participant.
	 * @param participantB The second participant.
	 * @param rng The RNG to use for coin flips and deck shuffles.
	 */
	public Match(Participant participantA, Participant participantB, Random rng) {
		this.participantA = participantA;
		this.participantB = participantB;
		this.rng          = rng;
	}
	
	/**
	 * Set up the match.
	 */
	public void setupMatch() {
		System.out.println("Participants: " + participantA.getName() + " and " + participantB.getName());
		System.out.println("Setting up match...");
		// TODO Shuffle participant decks.
		// TODO Set participant hands.
		// TODO Check for basic pokemon in both hands.
		// TODO Set participant prizes.
		// TODO Ask participants to pick active pokemon.
		
		// Choose the initial participant to play.
		this.chooseFirstParticipant();
	}
	
	/**
	 * Process a single turn for the active participant.
	 */
	public void processTurn() {
		// Write to the console whos turn it is.
		System.out.println();
		System.out.println(this.activeParticipant.getName() + "'s Turn!");
		// Carry out the pre-turn stage.
		this.activeParticipant.onPreTurn();
		// Carry out the actual turn stage.
		this.activeParticipant.onTurn(new TurnContext(this.activeParticipant));
		// Carry out the post-turn stage.
		this.activeParticipant.onPostTurn();
		// Swap the active participant.
		this.swapActiveParticipant();
	}
	
	public Participant getWinningParticipant() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Choose the initial participant based on a coin flip.
	 */
	private void chooseFirstParticipant() {
		// Get a coin to use to find our initial player.
		Coin coin = new Coin(this.rng);
		// If we get heads then participantA will be our first player.
		this.activeParticipant = coin.flip() == Coin.FlipResult.HEADS ? 
				this.participantA : 
				this.participantB;
		// Write the news of the winner to the console.
		System.out.println();
		System.out.println(this.activeParticipant.getName() + " wins the coin toss and is going first!");
	}
	
	/**
	 * Swap the active participant.
	 */
	private void swapActiveParticipant() {
		if (this.activeParticipant == this.participantA) {
			this.activeParticipant = this.participantB;
		} else if (this.activeParticipant == this.participantB) {
			this.activeParticipant = this.participantA;
		}
	}
}
