package card;

import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import energy.EnergyFactory;
import ptcg_ai.Constants;
import ptcg_ai.Utilities;

/**
 * Factory for creating cards.
 */
public class CardFactory {
	/**
	 * The card library JSON file.
	 */
	private File libraryJSONFile;
	/**
	 * The map of card names to JSON card representations.
	 */
	private HashMap<String, JSONObject> cardJSONMap = new HashMap<String, JSONObject>();
	
	/**
	 * Creates a new instance of the CardFactory class.
	 */
	public CardFactory() {
		// Create the library JSON file.
		this.libraryJSONFile = new File(Constants.CARD_LIBRARY_PATH);
		// Check that the file actually exists.
		if (!this.libraryJSONFile.exists()) {
			throw new RuntimeException("Cannot file card library file at: " + this.libraryJSONFile.getAbsolutePath());
		}
		// The card library file contains a JSON array of cards.
		JSONArray cardArray = Utilities.readJSONArrayFromFile(this.libraryJSONFile);
		// Read from the card library file to populate the card map.
		populateCardMap(cardArray);
	}

	/**
	 * Read from the card library file to populate the card map.
	 * @param cardArray The card JSON array.
	 */
	private void populateCardMap(JSONArray cardArray) {
		try {
			// Read each card into the card JSON map.
			for(int cardIndex = 0; cardIndex < cardArray.length(); cardIndex++) {
				// Get the card name.
				String cardName = cardArray.getJSONObject(cardIndex).getString("name");
				// Check whether this card is already in our map (should not happen).
				if (this.cardJSONMap.containsKey(cardName.toLowerCase())) {
					// We found a duplicate!
					System.out.println("Found duplicate card'" + cardName + "' in card library file!");
				}
				// Put this card JSON in our map.
				this.cardJSONMap.put(cardName.toLowerCase(), cardArray.getJSONObject(cardIndex));
			}
		} catch (JSONException e) {
			throw new RuntimeException("Error reading from card library file at: " + this.libraryJSONFile.getAbsolutePath());
		}
	}

	/**
	 * Creates a fresh card of the specified name.
	 * @param name The name of the card to create.
	 * @return The created card.
	 */
	public ICard createCard(String name) {
		// This card has to be in our card JSON map otherwise it is not a recognised card.
		if (!this.cardJSONMap.containsKey(name.toLowerCase())) {
			throw new RuntimeException("The card '" + name + "' does not exist in the card library!");
		}
		// Get the JSON object that represents this card.
		JSONObject cardJSON = this.cardJSONMap.get(name.toLowerCase());
		try {
			// Get the card type of this card.
			CardType cardType = CardType.valueOf(cardJSON.getString("type").toUpperCase());
			// The type of card we create depends on its type.
			switch (cardType) {
				case ENERGY:
					return EnergyFactory.create(cardJSON);
				case POKEMON:
					return null; // TODO!
				case TRAINER:
					return null; // TODO!
				default:
					throw new RuntimeException("Unexpected card type '" + cardType + "'!"); 
			}
		} catch (JSONException e) {
			throw new RuntimeException("Error getting type of card'" + name + "'!");
		}
	}
}
