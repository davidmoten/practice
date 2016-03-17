package algorithms;

import java.util.List;

public class Sorting {

    public static int indexOf(int[] a, int value) {
        return indexOf(a, 0, a.length, value);
    }

    private static int indexOf(int[] a, int start, int size, int value) {
        if (size == 0) {
            return start;
        } else if (size == 1) {
            if (a[start] == value)
                return start;
            else
                return start + 1;
        } else if (value < a[start]) {
            return start;
        } else if (value > a[start + size - 1]) {
            return start + size;
        } else {
            int chunkSize = size / 2;
            if (value <= a[start + chunkSize]) {
                return indexOf(a, start, chunkSize, value);
            } else {
                return indexOf(a, start + chunkSize + 1, a.length - chunkSize - 1, value);
            }
        }

    }

    public static long reverseBits(long x) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result |= (x & 1);
            x = x >> 1;
        }
        return result;
    }

    public static int searchInsert(List<Integer> a, int b) {

        if (a.size() == 0) {
            return 0;
        }
        int i = 0;
        int j = a.size() - 1;

        while (true) {
            if (b < a.get(i)) {
                return i;
            } else if (b > a.get(j)) {
                return j + 1;
            } else if (b == a.get(i)) {
                return i;
            } else if (b == a.get(j)) {
                return j;
            } else if (i + 1 == j) {
                return j;
            } else if (i == j) {
                return i;
            } else {
                int k = (i + j) / 2;
                if (b <= a.get(k)) {
                    j = k;
                } else {
                    i = k;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Long.toBinaryString(3));

        System.out.println(Long.toBinaryString(reverseBits(3)));
        System.out.println(reverseBits(3));
        System.out.println(indexOf(new int[] { 1, 2, 3, 5, 6 }, 7));

    }

}
