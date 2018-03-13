package participant.player.input;

import match.TurnContext;
import ptcg_ai.GamePrinter;
import java.util.Scanner;

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
        while(true) {
            // Has the player ended their turn?
            if (input.toLowerCase().equals("end turn")) {
                break;
            }
            // Process this command.
            String[] command = input.split(" ");
            // If the command is empty then offer some help.
            if (command[0].isEmpty()) {
                this.onEmptyInput();
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
     * Called when a command is empty.
     */
    private void onEmptyInput() {
        System.out.println("Need help? Type HELP");
    }

    /**
     * Process a player command.
     * @param command The player command.
     * @param context The turn context.
     */
    private void processCommand(String[] command, TurnContext context) {
        // Is this a valid command?
        try {
            InputCommand.valueOf(command[0].toUpperCase());
        } catch (IllegalArgumentException ex) {
            // This is not a valid input command.
            System.out.println(command[0] + " is not a valid command. Try HELP.");
            return;
        }
        // Do something based on the command type.
        switch(InputCommand.valueOf(command[0].toUpperCase())) {
            case CHECK:
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
            default:
                onEmptyInput();
        }
    }
    
    
    /**
     * Process a player CHECK command.
     * @param command The player command.
     * @param context The turn context.
     */
    private void processCheckCommand(String[] command, TurnContext context) {
    	// The player wants to check something.
    	// If no other parameters are defined then we should check the player board.
    	if (command.length == 1)
    	{
    		// TODO Check game board.
    	}
    	else
    	{
    		if (command[1].toUpperCase().equals("OPPONENT")) {
    			
    		} else {
    			
    		}
    		// TODO A command following 'Check' might be 'opponent'.
    		// A command following 'Check' must be a target.
            try {
                CheckTarget.valueOf(command[1].toUpperCase());
            } catch (IllegalArgumentException ex) {
                // This is not a valid check target command.
                System.out.println("'" + command[1] + "' is not a valid target. Try [card|hand|bench|discarded|active] or HELP.");
                return;
            }
    		switch(CheckTarget.valueOf(command[1].toUpperCase())) {
				case ACTIVE:
					break;
				case BENCH:
					// TODO Could have 1-5 or nothing following.
					break;
				case CARD:
					// TODO Could have 1-5 or any name following.
					break;
				case DISCARDED:
					break;
				case HAND:
					GamePrinter.printHand(context.getParticipant().getHand());
					break;
    		}
    	}
    }
}
