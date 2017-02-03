import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 3;

	/**
	 * The number of values to shuffle.
	 */
	private static final int VALUE_COUNT = 4;

	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = new int[VALUE_COUNT];
		for (int i = 0; i < values1.length; i++) {
			values1[i] = i;
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = new int[VALUE_COUNT];
		for (int i = 0; i < values2.length; i++) {
			values2[i] = i;
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int[] shuffled = new int[values.length];
		int k = 0;
		for(int i = 0; i < values.length/2; i++) {
			shuffled[k] = values[i];
			k += 2;
		}
		k = 1;
		for(int i = values.length/2; i< values.length; i++) {
            shuffled[k] = values[i];
            k += 2;
        }
        for(int i = 0; i < values.length; i++) {
            values[i] = shuffled[i];
        }
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		int[] shuffled = new int[values.length];
		Random rand = new Random();
        int randomNumber = rand.nextInt(values.length);
		for (int i = 0; i < values.length; i++) {
			while(values[randomNumber] == -1) {
				randomNumber = rand.nextInt(values.length);
			}
			shuffled[i] = values[randomNumber];
			values[randomNumber] = -1;
		}
		for(int i = 0; i < values.length; i++) {
            values[i] = shuffled[i];
        }
	}

	public static String flip() {
        Random rand = new Random();
        if(rand.nextInt(3) < 2 )
            return "heads";
        return "tails";
    }
    public static boolean arePermutations(int[] arrayOne, int[] arrayTwo) {
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);

		for (int i = 0; i < arrayOne.length; i++) {
			if (arrayOne[i] != arrayTwo[i])
				return false;
		}
		return true;
	}
}
