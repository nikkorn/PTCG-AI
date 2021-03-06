package ptcg_ai;

import java.util.Random;
import card.CardLibrary;
import match.DeckBuilder;
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
		if (args.length != 7) {
			System.out.println("Expected 7 arguments:");
			System.out.println("1. The name of the first participant.");
			System.out.println("2. The type of the first participant (computer/player)");
			System.out.println("3. The name of the deck that the first participant will use.");
			System.out.println("4. The name of the second participant.");
			System.out.println("5. The type of the second participant (computer/player)");
			System.out.println("6. The name of the deck that the second participant will use.");
			System.out.println("7. The number of prizes.");
			return;
		}

		// Print a pretty splash to the console.
		printSplash();
		
		// Load the card library from disk.
		CardLibrary.loadFromDisk();
		
		// Create the participants.
		Participant firstParticipant  = createParticipant(args[0], args[1]);
		Participant secondParticipant = createParticipant(args[3], args[4]);
		
		// Build the decks of the two participants.
		firstParticipant.setDeck(DeckBuilder.createDeck(args[2]));
		secondParticipant.setDeck(DeckBuilder.createDeck(args[5]));
		
		// Get the number of prizes.
		int prizes = Integer.parseInt(args[6]);
		
		// Create the match.
		Match match = new Match(firstParticipant, secondParticipant, prizes, new Random());
		
		// Set up the match.
		match.setupMatch();
		
		// A match consists on the two participants taking turns until we have a winner.
		while (match.getWinningParticipant() == null) {
			// Process the next turn in the match.
			match.processTurn();
		}
		
		 // We have a winner!
		System.out.println();
		System.out.println("The winner is: " + match.getWinningParticipant().getName());
	}

	/**
	 * Print a splash to the console.
	 */
	private static void printSplash() {
		System.out.println("  __________ ____________________    ________             _____    ___ ");
		System.out.println("  \\______   \\\\__    ___/\\_   ___ \\  /  _____/            /  _  \\  |   |");
		System.out.println("   |     ___/  |    |   /    \\  \\/ /   \\  ___   ______  /  /_\\  \\ |   |");
		System.out.println("   |    |      |    |   \\     \\____\\    \\_\\  \\ /_____/ /    |    \\|   |");
		System.out.println("   |____|      |____|    \\______  / \\______  /         \\____|__  /|___|");
		System.out.println("                                \\/         \\/                  \\/      ");
		System.out.println();
		System.out.println("version 0.0.1");
	}

	/**
	 * Create either a player or AI based participant.
	 * @param name The participant name.
	 * @param type The participant type (player/computer)
	 * @return The participant.
	 */
	private static Participant createParticipant(String name, String type) {
		// The type of participant we create depends on
		if (type.toLowerCase().equals("player")) {
			return new Player(name);
		} else if (type.toLowerCase().equals("computer")) {
			return new AI(name);
		} else {
			throw new RuntimeException("Expected participant type of 'player' or 'computer' but got: " + type);
		}
	}
}
