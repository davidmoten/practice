package algorithms;

import java.util.Arrays;

public final class QuickSort {

	private QuickSort() {
		// prevent instantiation
	}

	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(int[] a, int from, int to) {
		if (from >= to) {
			return;
		} else {
			int j = partition(a, from, to);
			sort(a, from, j - 1);
			sort(a, j + 1, to);
		}
	}

	private static int partition(int[] a, int from, int to) {
		int v = a[(from + to) / 2];// pivot value (arbitrary)
		int i = from;
		int j = to;
		while (i <= j) {
			while (a[i] < v) {
				i++;
			}
			while (a[j] > v) {
				j--;
			}
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		return i - 1;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 5, 4, 3, 2, 1, 6,7,8,3,2,1 };
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
