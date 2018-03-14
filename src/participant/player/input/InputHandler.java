package participant.player.input;

import match.TurnContext;
import output.CardPrinter;
import output.GamePrinter;
import java.util.Scanner;
import java.util.Stack;

/**
 * Handles console input from a player.
 */
public class InputHandler {

	/**
	 * Start polling for player input.
	 * @param context The turn context.
	 */
	public void startInputLoop(TurnContext context) {
		// Create a scanner to read player input.
		Scanner inputScanner = new Scanner(System.in);
		// Print the input cursor.
		GamePrinter.printInputCursor();
		// Get the first line of input.
		String input = inputScanner.nextLine();
		// Read input until the player ends their turn.
		while (true) {
			// Has the player ended their turn?
			if (input.toLowerCase().equals("end turn")) {
				break;
			}
			// Process this command.
			Stack<String> command = createCommandStack(input.split(" "));
			// If the command is empty then offer some help.
			if (command.isEmpty()) {
				System.out.println("Need help? Type HELP");
				System.out.println();
			} else {
				this.processCommand(command, context);
			}
			// Print the input cursor.
			GamePrinter.printInputCursor();
			// Get the next line of input.
			input = inputScanner.nextLine();
		}
	}

	/**
	 * Process a player command.
	 * @param command The player command.
	 * @param context The turn context.
	 */
	private void processCommand(Stack<String> command, TurnContext context) {
		// Is this a valid command?
		try {
			InputCommand.valueOf(command.peek().toUpperCase());
		} catch (IllegalArgumentException ex) {
			// This is not a valid input command.
			System.out.println(command.peek() + " is not a valid command. Try HELP.");
			return;
		}
		InputCommand inputCommand = InputCommand.valueOf(command.pop().toUpperCase());
		// Do something based on the command type.
		switch (inputCommand) {
			case CHECK:
				// The player wants to check something.
				processCheckCommand(command, context);
				break;
			case PLAY:
				break;
			case ATTACK:
				break;
			case RETREAT:
				break;
			case POKEPOWER:
				break;
			case HELP:
				// Print help information to the console.
				GamePrinter.printHelp();
				break;
		}
	}

	/**
	 * Process a player CHECK command.
	 * @param command The player command.
	 * @param context The turn context.
	 */
	private void processCheckCommand(Stack<String> command, TurnContext context) {
		// If no other parameters are defined then we should check the player board.
		if (command.isEmpty()) {
			// TODO Check player game board.
		} else {
			boolean isCheckingOpponent = false;
			// A command following 'Check' might be 'opponent'.
			if (command.peek().toUpperCase().equals("OPPONENT")) {
				isCheckingOpponent = true;
				command.pop();
				// If no other parameters are defined then we should check the opponent board.
				if (command.isEmpty()) {
					// TODO Check opponent game board.
					return;
				}
			}
			// A command following 'Check' or 'Opponent' must be a target.
			try {
				CheckTarget.valueOf(command.peek().toUpperCase());
			} catch (IllegalArgumentException ex) {
				// This is not a valid check target command.
				System.out.println("'" + command.peek() + "' is not a valid target. Try [card|hand|bench|discarded|active] or HELP.");
				System.out.println();
				return;
			}
			switch (CheckTarget.valueOf(command.pop().toUpperCase())) {
			case ACTIVE:
				// Whose active pokemon are we checking?
				if (isCheckingOpponent) {
					CardPrinter.print(context.getOpponent().getActivePokemon(), true);
				} else {
					CardPrinter.print(context.getParticipant().getActivePokemon(), true);
				}
				break;
			case BENCH:
				// TODO Could have 1-5 or nothing following.
				break;
			case CARD:
				// The next part of the command must be a card name.
				if (command.isEmpty()) {
					System.out.println("Please provide the card name. CHECK CARD [card name]");
					System.out.println();
					return;
				}
				// Print the card.
				CardPrinter.print(command.pop(), true);
				break;
			case DISCARDED:
				// Whose discard pile are we checking?
				if (isCheckingOpponent) {
					GamePrinter.printDiscarded(context.getOpponent().getDiscardPile());
				} else {
					GamePrinter.printDiscarded(context.getParticipant().getDiscardPile());
				}
				break;
			case HAND:
				// We cannot check the hand of our opponent.
				if (isCheckingOpponent) {
					System.out.println("Cannot check the hand of your opponent.");
					System.out.println();
				} else {
					GamePrinter.printHand(context.getParticipant().getHand());
				}
				break;
			}
		}
	}

	/**
	 * Create a command stack.
	 * @param command The command.
	 * @return The command stack.
	 */
	private Stack<String> createCommandStack(String[] command) {
		Stack<String> commandStack = new Stack<String>();
		for (int i = command.length - 1; i >= 0; i--) {
			commandStack.add(command[i]);
		}
		return commandStack;
	}
}
