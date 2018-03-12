package pokemon;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import energy.EnergyType;
import moves.Move;

/**
 * Factory for creating Pokemon creature cards.
 */
public class PokemonFactory {
	
	/**
	 * Create the Pokemon card.
	 * @param cardJSON The JSON object representing the card.
	 * @return The created card.
	 * @throws JSONException 
	 */
	public static Pokemon create(JSONObject cardJSON) throws JSONException {
		// Parse the pokemon card details from the JSON.
		String name         = cardJSON.getString("name");
		EnergyType type     = EnergyType.valueOf(cardJSON.getString("energyType").toUpperCase());
		String preEvolution = cardJSON.getString("preEvolution");
		int hp              = cardJSON.getInt("hp");
		
		// Create the pokemon weakness/resistance objects and the move set.
		Resistance resistance = createResistance(cardJSON.getJSONObject("resistance"));
		Weakness weakness     = createWeakness(cardJSON.getJSONObject("weakness"));
		ArrayList<Move> moves = createMoveSet(cardJSON.getJSONArray("moves"));

		// Create and return the pokemon card!
		return new Pokemon(name, type, preEvolution, moves, resistance, weakness, hp);
	}

	/**
	 * Create the list of moves that make up the pokemon's move set.
	 * @param jsonArray The JSON array representing the pokemon's move set.
	 * @return The move set.
	 */
	private static ArrayList<Move> createMoveSet(JSONArray jsonArray) {
		return null;
	}

	/**
	 * Create the Weakness instance for the pokemon.
	 * @param jsonObject The JSON object representing the pokemon weakness.
	 * @return The pokemon weakness.
	 */
	private static Weakness createWeakness(JSONObject jsonObject) {
		return null;
	}

	/**
	 * Create the Resistance instance for the pokemon.
	 * @param jsonObject The JSON object representing the pokemon resistance.
	 * @return The pokemon resistance.
	 */
	private static Resistance createResistance(JSONObject jsonObject) {
		return null;
	}
}
