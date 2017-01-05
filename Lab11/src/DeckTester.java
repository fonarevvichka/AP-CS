/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] rank = {"ace", "king", "queen"};
		String[] suitBase = {"hearts", "spades"};
		int[] pointValues = {1, 13, 12};

		Deck bad = new Deck(rank, suitBase, pointValues);
		System.out.println(bad.isEmpty());
	}
}
