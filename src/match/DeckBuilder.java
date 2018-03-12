package match;

import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import card.CardLibrary;
import card.ICard;
import ptcg_ai.Constants;
import ptcg_ai.Utilities;

/**
 * Builds and validates a deck.
 */
public class DeckBuilder {
	
	/**
	 * Create a deck.
	 * @param name The name of the deck configuration.
	 * @return The created deck.
	 * @throws JSONException 
	 */
	public static Deck createDeck(String name) {
		System.out.println("Loading deck configuration '" + name + "' from disk...");
		// Get a handle for the deck configuration file.
		File cardConfigFile = new File(Constants.DECK_CONFIG_DIR + name + ".json");
		// Check that the file actually exists.
		if (!cardConfigFile.exists()) {
			throw new RuntimeException("Cannot find deck config file at: " + cardConfigFile.getAbsolutePath());
		}
		// The deck configuration file contains a JSON array of cards.
		JSONObject deckConfig = Utilities.readJSONObjectFromFile(cardConfigFile);
		// Get the deck name.
		String deckName = null;
		try {
			deckName = deckConfig.getString("name");
		} catch (JSONException e) {
			throw new RuntimeException("Error reading name from deck config file at: " + cardConfigFile.getAbsolutePath());
		}
		// Create an empty deck with the deck name.
		Deck deck = new Deck(deckName);
		// Get the deck card list.
		JSONArray cardsJson = null;
		try {
			cardsJson = deckConfig.getJSONArray("cards");
		} catch (JSONException e) {
			throw new RuntimeException("Error reading card list from deck config file at: " + cardConfigFile.getAbsolutePath());
		}
		// Create the cards that make up this deck and add them to it.
		deck.addAll(DeckBuilder.createDeckCards(cardsJson, cardConfigFile.getAbsolutePath()));
		// Return the complete and validated deck.
		return deck;
	}
	
	/**
	 * Create the cards that the deck is composed of.
	 * @param cardsJson The JSON array holding the card names.
	 * @param deckConfigPath The deck config path.
	 * @return The cards that the deck is composed of.
	 */
	private static ArrayList<ICard> createDeckCards(JSONArray cardsJson, String deckConfigPath) {
		ArrayList<ICard> cardList = new ArrayList<ICard>();
		try {
			// Read each card into the card list.
			for(int cardIndex = 0; cardIndex < cardsJson.length(); cardIndex++) {
				// Get the card name.
				String cardName = cardsJson.getString(cardIndex);
				// Create this card and add it to our card list.
				cardList.add(CardLibrary.createCard(cardName));
			}
		} catch (JSONException e) {
			throw new RuntimeException("Error reading card list contents from deck config file at: " + deckConfigPath);
		}
		// Validate the list of cards in this deck.
		// We must have a deck of 60 cards.
		if (cardList.size() != Constants.DECK_REQUIRED_SIZE) {
			throw new RuntimeException("A deck should have " + Constants.DECK_REQUIRED_SIZE + " cards. Only " + cardList.size() + " defined in the deck config file at: " + deckConfigPath);
		}
		// TODO We cannot have more than 4 of a single card type.
		return cardList;
	}
}
