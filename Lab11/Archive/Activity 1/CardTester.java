/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
        Card card1  = new Card("Ace", "Spades", 1);
        Card card2  = new Card("Ace", "Spades", 1);
        Card card3  = new Card("2", "Clubs", 2);


        System.out.println(card1.pointValue());
        System.out.println(card1.suit());
        System.out.println(card1.rank());

        System.out.print(card1.matches(card3));
    }
}
