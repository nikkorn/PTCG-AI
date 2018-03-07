package participant.player;

import match.TurnContext;
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
        // Print an input que.
        System.out.print("> ");
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
            // Print an input que.
            System.out.print("> ");
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
                printHelp();
                break;
            default:
                onEmptyInput();
        }
    }

    /**
     * Print help information to the console.
     */
    private void printHelp() {
        System.out.println("################################# HELP ##################################");
        System.out.println("#########################################################################");
        System.out.println("# CHECK [hand|1-6]      Checks the specified target. Either the hand    #");
        System.out.println("#                       of the player or a pokemon index (1=active,     #");
        System.out.println("#                       2-6=benched).                                   #");
        System.out.println("# PLAY index            Plays the card with the specified hand index.   #");
        System.out.println("# RETREAT index         Retreat the active pokemon, paying the retreat  #");
        System.out.println("#                       cost for the active pokemon and swapping it     #");
        System.out.println("#                       for the pokemon at the specified bench index.   #");
        System.out.println("# ATTACK move           Attacks with the specified move.                #");
        System.out.println("# POKEPOWER 1-6         Triggers a pokepower for pokemon at the         #");
        System.out.println("#                       specified index (1=active, 2-6=benched).        #");
        System.out.println("# END TURN              End the turn.                                   #");
        System.out.println("#########################################################################");
        System.out.println();
    }
}
