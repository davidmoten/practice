package algorithms;

public class QuickSort {

	public static void sort(int[] a) {
		if (a.length <= 1) {
			return;
		} else {
			quicksort(a, 0, a.length - 1);
		}
	}

	private static void quicksort(int[] a, int from, int to) {

		int pivot = a[(from + to) / 2];

		int i = from;
		int j = to;

		while (i <= j) {
			while (a[i] < pivot) {
				i++;
			}

			while (a[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		if (from < j)
			quicksort(a, from, j);
		if (i < to)
			quicksort(a, i, to);

	}

	private static void swap(int[] a, int i, int j) {
		int x = a[i];
		a[i] = a[j];
		a[j] = x;
	}

}
