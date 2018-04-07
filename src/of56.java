/**
 * Created by xinchang on 2018/4/7.
 */
public class of56 {
    private static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int pivot = a[left];
            int lo = left;
            int hi = right;
            while (lo < hi) {
                while (lo < hi && a[hi] >= pivot) {
                    hi--;
                }
                a[lo] = a[hi];
                while (lo < hi && a[lo] <= pivot) {
                    lo++;
                }
                a[hi] = a[lo];
            }
            a[lo] = pivot;
            quickSort(a, left, lo - 1);
            quickSort(a, lo + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {91, 23, 43, 12, 23, 43, 5, 6, 2, 1, 3, 4};
        quickSort(arr);
        for(int i : arr) {
            System.out.print(i+"   ");
        }
    }
}
