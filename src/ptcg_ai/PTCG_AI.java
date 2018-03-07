package ptcg_ai;

import java.util.Random;
import match.Match;
import participant.Participant;
import participant.ai.AI;
import participant.player.Player;

/**
 * Entry point.
 */
public class PTCG_AI {

	/**
	 * Entry point for the program.
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		
		// Check for the relevant arguments.
		if (args.length != 6) {
			System.out.println("Expected 6 arguments:");
			System.out.println("1. The name of the first participant.");
			System.out.println("2. The type of the first participant (computer/player)");
			System.out.println("3. The deck configuration path of the first participant.");
			System.out.println("4. The name of the second participant.");
			System.out.println("5. The type of the second participant (computer/player)");
			System.out.println("6. The deck configuration path of the second participant.");
			return;
		}
		
		// Create the match.
		Match match = new Match(createParticipant(args[0], args[1], args[2]), 
				createParticipant(args[3], args[4], args[5]), new Random());
		
		// Set up the match.
		match.setupMatch();
		
		// A match consists on the two participants taking turns until we have a winner.
		while (match.getWinningParticipant() == null) {
			// Process the next turn in the match.
			match.processTurn();
		}
		
		 // We have a winner!
		System.out.println("The winner is: " + match.getWinningParticipant().getName());
	}
	
	/**
	 * Create either a player or AI based participant.
	 * @param name The participant name.
	 * @param deckConfigurationPath The participant deck configuration path.
	 * @param type The participant type (player/computer)
	 * @return The participant.
	 */
	private static Participant createParticipant(String name, String deckConfigurationPath, String type) {
		// The type of participant we create depends on
		if (type.toLowerCase().equals("player")) {
			return new Player(name, deckConfigurationPath);
		} else if (type.toLowerCase().equals("computer")) {
			return new AI(name, deckConfigurationPath);
		} else {
			throw new RuntimeException("Expected participant type of 'player' or 'computer'. Got: " + type);
		}
	}
}