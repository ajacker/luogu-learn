package level2.mission10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * P1908 逆序对
 *
 * @author ajacker
 * @date 2019/11/29 13:00
 */
public class P1908 {

    private static int n;
    private static int[] nums;
    private static int[] temp;
    private static long count;

    public static void main(String[] args) {
        n = InputReader.nextInt();
        nums = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = InputReader.nextInt();
        }
        mergeSort(0, n - 1);
        System.out.print(count);
    }

    /**
     * 归并排序
     *
     * @param left
     * @param right
     */
    public static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }

    }

    /**
     * 归并步骤并计算逆序对
     *
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                //如果左半边部分的nums[i]这个数字比nums[j]大
                //则说明左半边部分的nums[i]到nums[mid]都比nums[j]大
                //也就是逆序对有mid-i+1个
                count += mid - i + 1;
                temp[t++] = nums[j++];
            }
        }
        System.arraycopy(nums, i, temp, t, mid - i + 1);
        System.arraycopy(nums, j, temp, t, right - j + 1);
        System.arraycopy(temp, 0, nums, left, right - left + 1);

    }


    final static class InputReader {
        final static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = null;

        static String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(READER.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}
