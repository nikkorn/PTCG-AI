package moves;

/**
 * An action to perform as part of a move.
 */
public interface IMoveAction {
	
	/**
	 * Perform the move action.
	 * @return Whether the action was performed with success.
	 */
	boolean perform();
}
