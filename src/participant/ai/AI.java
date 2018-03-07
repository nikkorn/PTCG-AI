package participant.ai;

import match.TurnContext;
import participant.Participant;

/**
 * Represents a computer controlled participant.
 */
public class AI extends Participant {

	/**
	 * Creates a new instance of the AI class.
	 * @param deckConfigurationPath The path to the participants deck configuration.
	 */
	public AI(String deckConfigurationPath) {
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
