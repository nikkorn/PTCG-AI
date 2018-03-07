package participant.player;

import match.TurnContext;
import participant.Participant;

/**
 * Represents a player participant.
 */
public class Player extends Participant {

	/**
	 * Creates a new instance of the Player class.
	 * @param name The name of the participant.
	 * @param deckConfigurationPath The path to the participants deck configuration.
	 */
	public Player(String name, String deckConfigurationPath) {
		super(name, deckConfigurationPath);
	}

	/**
	 * Called in response to it becoming the participant turn.
	 * @param context The turn context.
	 */
	@Override
	public void onTurn(TurnContext context) {
		// TODO Auto-generated method stub
	}
}
