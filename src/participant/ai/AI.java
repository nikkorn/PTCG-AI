package participant.ai;

import match.TurnContext;
import participant.Participant;

/**
 * Represents a computer controlled participant.
 */
public class AI extends Participant {

	/**
	 * Creates a new instance of the AI class.
	 * @param name The name of the participant.
	 */
	public AI(String name) {
		super(name);
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
