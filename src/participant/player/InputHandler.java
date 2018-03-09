package participant.player;

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
                this.processCommand(command);
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
     */
    private void processCommand(String[] command) {
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
}
