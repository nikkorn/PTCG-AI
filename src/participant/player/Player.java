package participant.player;

import match.TurnContext;
import participant.Participant;
import participant.player.input.InputHandler;

/**
 * Represents a player participant.
 */
public class Player extends Participant {

	/**
	 * Creates a new instance of the Player class.
	 * @param name The name of the participant.
	 */
	public Player(String name) {
		super(name);
	}

	/**
	 * Called in response to it becoming the participant turn.
	 * @param context The turn context.
	 */
	@Override
	public void onTurn(TurnContext context) {
		// Create an input handler for the player to use to input commands.
		InputHandler inputHandler = new InputHandler();
		// Start getting processing input commands.
		inputHandler.startInputLoop(context);
	}
}
