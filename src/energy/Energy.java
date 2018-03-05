package energy;

import card.CardType;
import card.ICard;

/**
 * Represents an energy card.
 */
public class Energy implements ICard {
	/**
	 * The energy type of the card.
	 */
	private EnergyType energyType;
	
	/**
	 * Creates a new instance of the Energy class.
	 * @param type The energy type of this card.
	 */
	public Energy(EnergyType type) {
		this.energyType = type;
	}
	
	/**
	 * Gets the energy type of this card.
	 * @return The energy type of this card. 
	 */
	public EnergyType getEnergyType() {
		return this.energyType;
	}

	/**
	 * Gets the card type.
	 * @return The card type.
	 */
	@Override
	public CardType getType() { return CardType.ENERGY; }
}
