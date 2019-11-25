package level2.mission3;

import java.util.Scanner;

/**
 * P1059 明明的随机数
 *
 * @author ajacker
 * @date 2019/11/25 21:57
 */
public class P1059 {
    private static int[] arr, temp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        mergeSort(0, n - 1);
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i - 1 < 0 || arr[i - 1] != arr[i]) {
                count++;
                stringBuilder.append(arr[i]).append(" ");
            }
        }
        System.out.printf("%d\n%s", count, stringBuilder.toString());

    }

    public static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    public static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        System.arraycopy(arr, i, temp, t, mid - i + 1);
        System.arraycopy(arr, j, temp, t, right - j + 1);
        System.arraycopy(temp, 0, arr, left, right - left + 1);
    }
}
