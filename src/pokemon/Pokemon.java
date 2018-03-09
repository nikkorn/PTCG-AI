package pokemon;

import java.util.ArrayList;
import card.CardType;
import card.ICard;
import energy.Energy;
import energy.EnergyCost;
import energy.EnergyType;
import moves.Move;

/**
 * Represents a pokemon card.
 */
public class Pokemon implements ICard {
	/**
	 * The name of the pokemon.
	 */
	private String name;
	/**
	 * The energy type of this pokemon.
	 */
	private EnergyType type;
	/**
	 * The name of the pre-evolution of this pokemon. 
	 */
	private String preEvolution;
	/**
	 * The list of moves this pokemon can perform.
	 */
	private ArrayList<Move> moves;
	/**
	 * The resistance of the pokemon.
	 */
	private Resistance resistance = null;
	/**
	 * The weakness of the pokemon.
	 */
	private Weakness weakness = null;
	/**
	 * The overall HP of the pokemon.
	 */
	private int hp;
	/**
	 * The status of the pokemon.
	 */
	private StatusEffect status = StatusEffect.NONE;
	/**
	 * The damage tokens attached to this pokemon.
	 */
	private int damageTokens = 0; 
	/**
	 * The energy cards attached to this pokemon.
	 */
	private ArrayList<Energy> attachedEnergyCards = new ArrayList<Energy>();
	/**
	 * The retreat cost.
	 */
	private EnergyCost retreatCost;
	
	/**
	 * Creates a new instance of the Pokemon class.
	 * @param name The name of the pokemon.
	 * @param type The type of the pokemon.
	 * @param preEvolution The name of the pre-evolution of this pokemon. 
	 * @param moves The list of moves this pokemon can perform.
	 * @param resistance The resistance of the pokemon.
	 * @param weakness The weakness of the pokemon.
	 * @param hp The overall HP of the pokemon.
	 */
	public Pokemon(String name, EnergyType type, String preEvolution, ArrayList<Move> moves,
			Resistance resistance, Weakness weakness, int hp) {
		this.name         = name;
		this.type         = type;
		this.preEvolution = preEvolution;
		this.moves        = moves;
		this.resistance   = resistance;
		this.weakness     = weakness;
		this.hp           = hp;
	}
	
	/**
	 * Gets the name of the pokemon.
	 * @return The name of the pokemon.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the energy type of this pokemon.
	 * @return The energy type of this pokemon.
	 */
	public EnergyType getEnergyType() {
		return this.type;
	}
	
	/**
	 * Gets the pre-evolution of the pokemon.
	 * @return The pre-evolution of the pokemon.
	 */
	public String getPreEvolution() {
		return this.preEvolution;
	}
	
	/**
	 * Gets the resistance of the pokemon.
	 * @return The resistance of the pokemon.
	 */
	public Resistance getResistance() {
		return this.resistance;
	}
	
	/**
	 * Gets the weakness of the pokemon.
	 * @return The weakness of the pokemon.
	 */
	public Weakness getWeakness() {
		return this.weakness;
	}
	
	/**
	 * Gets the retreat cost of this pokemon.
	 * @return The retreat cost of this pokemon.
	 */
	public EnergyCost getRetreatCost() {
		return this.retreatCost;
	}
	
	/**
	 * Gets the HP of the pokemon.
	 * @return The HP of the pokemon.
	 */
	public int getHP() {
		return this.hp;
	}
	
	/**
	 * Gets the number of damage tokens attached to this pokemon.
	 * @return The number of damage tokens attached to this pokemon.
	 */
	public int getDamageTokens() {
		return this.damageTokens;
	}
	
	/**
	 * Sets the number of damage tokens attached to this pokemon.
	 * @param tokens The number of damage tokens attached to this pokemon.
	 */
	public void setDamageTokens(int tokens) {
		this.damageTokens = tokens;
	}
	
	/**
	 * Gets the status of the pokemon.
	 * @return The status of the pokemon.
	 */
	public StatusEffect getStatusEffect() {
		return this.status;
	}
	
	/**
	 * Sets the status of the pokemon.
	 * @param status The status of the pokemon.
	 */
	public void setStatusEffect(StatusEffect status) {
		this.status = status;
	}
	
	/**
	 * Gets the list of attached energy cards.
	 * @return The list of attached energy cards.
	 */
	public ArrayList<Energy> getAttachedEnergyCards() {
		return this.attachedEnergyCards;
	}
	
	/**
	 * Gets the list of moves that this pokemon can perform.
	 * @return The list of moves that this pokemon can perform.
	 */
	public ArrayList<Move> getMoves() {
		return this.moves;
	}
	
	/**
	 * Gets the card type.
	 * @return The card type.
	 */
	@Override
	public CardType getType() { return CardType.POKEMON; }
}
