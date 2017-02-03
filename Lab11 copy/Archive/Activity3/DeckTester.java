/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
//		String[] rank = {"ace", "king", "queen"};
//		String[] suitBase = {"hearts", "spades"};
//		int[] pointValues = {1, 13, 12};

//		Deck bad = new Deck(rank, suitBase, pointValues);
//		System.out.println(bad.isEmpty());
//		System.out.println(bad.size());
//		System.out.println(bad.toString());
//		System.out.println(bad.deal().toString());
//		System.out.println(bad.toString());

//		String[] rank2 = {"ace", "king"};
//		String[] suitBase2 = {"hearts", "spades", "ppop"};
//		int[] pointValues2 = {1, 13, 12};
//
//		Deck two = new Deck(rank2, suitBase2, pointValues2);
//		System.out.println(two.isEmpty());
//		System.out.println(two.size());
//		System.out.println(two.toString());
//		System.out.println(two.deal().toString());
//		System.out.println(two.toString());

//		String[] rank3 = {};
//		String[] suitBase3 = {"hearts", "spades"};
//		int[] pointValues3 = {};
//
//		Deck three = new Deck(rank3, suitBase3, pointValues3);
//		System.out.println(three.isEmpty());
//		System.out.println(three.size());
//		System.out.println(three.toString());
//		System.out.println(three.deal().toString());
//		System.out.println(three.toString());

		String[] rank = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack","Queen", "King", "Ace"};
		int[] pointValue = {1,2,3,4,5,6,7,8,9,10,10,10,10,11};
		String[] suits = {"spades", "clubs", "hearts", "diamonds"};
		Deck twentyOne = new Deck(rank, suits, pointValue);
	}
}
