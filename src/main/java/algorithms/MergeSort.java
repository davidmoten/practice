package algorithms;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] values) {
        return sort(values, 0, values.length);
    }

    private static int[] sort(int[] values, int from, int to) {
        System.out.println("sort " + from + ".." + to + " " + Arrays.toString(values));
        if (from >= to)
            return new int[0];
        else if (from == to - 1) {
            return new int[] { values[from] };
        } else {
            int mid = (from + to) / 2;
            int[] x = sort(values, from, mid);
            int[] y = sort(values, mid + 1, to);
            return merge(x, y);
        }
    }

    private static int[] merge(int[] x, int[] y) {
        System.out.println("merge" + Arrays.toString(x) + ":" + Arrays.toString(y));
        int[] result = new int[x.length + y.length];
        int n = 0;
        if (x.length == 0)
            return y;
        else if (y.length == 0)
            return x;
        else {
            int i = 0;
            int j = 0;
            while (i < x.length || j < y.length) {
                if (i >= x.length) {
                    result[n] = y[j];
                    n++;
                    j++;
                } else if (j >= y.length) {
                    result[n] = x[i];
                    n++;
                    i++;
                } else if (x[i] < y[j]) {
                    result[n] = x[i];
                    n++;
                    i++;
                } else {
                    result[n] = y[j];
                    n++;
                    j++;
                }
            }
        }
        System.out.println("returning " + Arrays.toString(result));
        return result;
    }

}
