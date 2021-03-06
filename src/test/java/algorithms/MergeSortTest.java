package algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest {

    @Test
    public void sortEmpty() {
        MergeSort.sort(new int[0]);
    }

    @Test
    public void sortOne() {
        int[] a = { 1 };
        MergeSort.sort(a);
        assertEquals(1, a[0]);
    }

    @Test
    public void sortTwoInOrder() {
        int[] a = { 1, 2 };
        int[] b = { 1, 2 };
        check(a, b);
    }

    @Test
    public void sortTwoOutOfOrder() {
        int[] a = { 2, 1 };
        int[] b = { 1, 2 };
        check(a, b);
    }

    private void check(int[] a, int[] b) {
        MergeSort.sort(a);
        assertTrue(Arrays.equals(b, a));
    }

    @Test
    public void sortThree() {
        int[] b = { 1, 2, 3 };
        {
            int[] a = { 1, 2, 3 };
            check(a, b);
        }
        {
            int[] a = { 1, 3, 2 };
            check(a, b);
        }
        {
            int[] a = { 2, 1, 3 };
            check(a, b);
        }
        {
            int[] a = { 2, 3, 1 };
            check(a, b);
        }
        {
            int[] a = { 3, 1, 2 };
            check(a, b);
        }
        {
            int[] a = { 3, 2, 1 };
            check(a, b);
        }

    }

}
