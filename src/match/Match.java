package match;

import java.util.Random;

import output.GamePrinter;
import participant.Participant;
import ptcg_ai.Constants;

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
		// Shuffle participant decks.
		System.out.println("Shuffling the decks...");
		participantA.getDeck().shuffle();
		participantB.getDeck().shuffle();
		// Find initial hands for the participants, then must include at least one basic pokemon.
		System.out.println("Drawing hands...");
		setInitialHand(participantA);
		setInitialHand(participantB);
		
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
		this.activeParticipant.onTurn(new TurnContext(this.activeParticipant,
				this.activeParticipant == participantA ? participantB : participantA));
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
		System.out.println("Flipping a coin to see who goes first! Heads: " + this.participantA.getName() + " Tails: " + this.participantB.getName());
		// Get a coin to use to find our initial player.
		Coin coin = new Coin(this.rng);
		// Get the result of flipping the coin.
		Coin.FlipResult result = coin.flip();
		// Print the coin flip to the console.
		GamePrinter.printCoinFlip(result);
		// If we get heads then participantA will be our first player.
		this.activeParticipant = result == Coin.FlipResult.HEADS ? 
				this.participantA : 
				this.participantB;
		// Write the news of the winner to the console.
		System.out.println();
		System.out.println(this.activeParticipant.getName() + " wins the coin toss and is going first!");
	}
	
	/**
	 * Set the initial hand of the participant.
	 * @param participant The participant.
	 */
	private void setInitialHand(Participant participant) {
		// Peek at the top cards of the participant deck that would make up their hand.
		Hand hand = new Hand(participant.getDeck().peekAtCards(Constants.HAND_DEFAULT_SIZE));
		// Keep creating hands for this participant until we have one with a basic pokemon.
		while(!hand.containsBasicPokemon()) {
			// Shuffle the deck again.
			participant.getDeck().shuffle();
			// Create a new hand.
			hand = new Hand(participant.getDeck().peekAtCards(Constants.HAND_DEFAULT_SIZE));
		}
		// We now have a hand with at least one basic pokemon in it.
		participant.setHand(hand);
		// Actually pick up the cards in the hand from the deck.
		participant.getDeck().pickUpCards(Constants.HAND_DEFAULT_SIZE);
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
