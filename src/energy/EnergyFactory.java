package energy;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Factory for creating Energy cards.
 */
public class EnergyFactory {
	
	/**
	 * Create the Energy card.
	 * @param cardJSON The JSON object representing the card.
	 * @return The created card.
	 * @throws JSONException 
	 */
	public static Energy create(JSONObject cardJSON) throws JSONException {
		// The type of this energy is derived from its name.
		EnergyType type = EnergyType.valueOf(cardJSON.getString("name").toUpperCase());
		// Create and return the Energy card!
		return new Energy(type);
	}
}
