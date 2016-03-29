package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Combinations {

	public static List<List<Integer>> combinations(int n, int k) {
		if (k > n / 2) {
			return complement(combinations(n, n - k), n);
		} else {
			return combinations(0, n, k);
		}
	}

	private static List<List<Integer>> complement(List<List<Integer>> combinations, int n) {
		List<List<Integer>> list = new ArrayList<>();
		for (List<Integer> c : combinations) {
			list.add(complementList(c, n));
		}
		return list;
	}

	private static List<Integer> complementList(List<Integer> c, int n) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 1; i <= n; i++) {
			set.add(i);
		}
		set.removeAll(c);
		return new ArrayList<Integer>(set);
	}

	private static List<List<Integer>> combinations(int start, int n, int k) {
		ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
		if (n == 0 || start > n) {
			return list;
		} else if (k == 0) {
			list.add(new ArrayList<>());
			return list;
		}

		for (List<Integer> b : combinations(start + 1, n, k - 1)) {
			b = new ArrayList<>(b);
			b.add(0, start);
			list.add(b);
		}
		list.addAll(combinations(start + 1, n, k));

		return list;
	}

	public static void main(String[] args) {
		System.out.println(combinations(4000, 4000));
	}
}
