package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<List<Integer>> permutations(int n, int k) {
		List<Integer> bucket = new ArrayList<>();
		for (int i = 1; i <= n;i++) {
			bucket.add(i);
		}
		return permutations(bucket, k);
	}

	private static List<List<Integer>> permutations(List<Integer> bucket, int k) {
		List<List<Integer>> list = new ArrayList<>();
		if (k == 0 ) {
			list.add(new ArrayList<>());
			return list;
		}
		for ( int i= 0; i< bucket.size(); i++) {
			List<Integer> smaller = new ArrayList<>(bucket);
			smaller.remove((int) i);
			for (List<Integer> a: permutations(smaller, k-1)) {
				a.add(bucket.get(i));
				list.add(a);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(permutations(3,2));
	}

}
