package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implicit immutable collection of all permutations of a string with an
 * iterator over the permutations.
 * <p>
 * implements Iterable&ltString&gt
 * 
 * @see #StringPermutation(String)
 */
public class StringPermutation implements Iterable<String> {

	// could implement Collection<String> but it's immutable, so most methods
	// are essentially vacuous

	protected final String string;

	/**
	 * Creates an implicit Iterable collection of all permutations of a string
	 * 
	 * @param string
	 *            String to be permuted
	 * @see Iterable
	 * @see #iterator
	 */
	public StringPermutation(String string) {
		this.string = string;
	}

	/**
	 * Constructs and sequentially returns the permutation values
	 */
	@Override
	public Iterator<String> iterator() {

		return new Iterator<String>() {

			char[] array = string.toCharArray();
			int length = string.length();
			int[] index = (length == 0) ? null : new int[length];

			@Override
			public boolean hasNext() {
				return index != null;
			}

			@Override
			public String next() {

				if (index == null)
					throw new NoSuchElementException();

				for (int i = 1; i < length; ++i) {
					char swap = array[i];
					System.arraycopy(array, 0, array, 1, i);
					array[0] = swap;
					for (int j = 1; j < i; ++j) {
						index[j] = 0;
					}
					if (++index[i] <= i) {
						return new String(array);
					}
					index[i] = 0;
				}
				index = null;
				return new String(array);
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		String s = "abcdefghijklmnopqrstuvwxyz";
		int r = 3;
		long i = 0;
		long maxCount = 1L << s.length();
		while (i < maxCount) {
			if (Long.bitCount(i) == r) {
				StringBuilder b = new StringBuilder();
				for (int j = 0; j < s.length(); j++) {
					if (((i >> j) & 1L) == 1L) {
						b.append(s.charAt(j));
					}
				}
				System.out.println(b.toString());
				i++;
			}
		}
	}
}