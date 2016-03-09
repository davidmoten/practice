package algorithms;

public final class QuickSort {

	private QuickSort() {
		//prevent instantiation
	}
	
	public static void sort(int[] a) {
		if (a.length <= 1) {
			return;
		} else {
			sort(a, 0, a.length - 1);
		}
	}

	private static void sort(int[] a, int from, int to) {

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
			sort(a, from, j);
		if (i < to)
			sort(a, i, to);

	}

	private static void swap(int[] a, int i, int j) {
		if (i == j)
			return;
		int x = a[i];
		a[i] = a[j];
		a[j] = x;
	}

}
