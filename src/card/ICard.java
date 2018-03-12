package card;

/**
 * Represents a game card.
 */
public interface ICard {
	
	/**
	 * Gets the card name.
	 * @return The card name.
	 */
	public String getName();
	
	/**
	 * Gets the card type.
	 * @return The card type.
	 */
	public CardType getType();
}
