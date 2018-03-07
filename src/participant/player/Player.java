package participant.player;

import match.TurnContext;
import participant.Participant;

/**
 * Represents a player participant.
 */
public class Player extends Participant {

	/**
	 * Creates a new instance of the Player class.
	 * @param deckConfigurationPath The path to the participants deck configuration.
	 */
	public Player(String deckConfigurationPath) {
		super(deckConfigurationPath);
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
