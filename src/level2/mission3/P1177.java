package level2.mission3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * P1177 【模板】快速排序
 *
 * @author ajacker
 * @date 2019/11/25 11:27
 */
public class P1177 {
    public static void main(String[] args) {
        int n = InputReader.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = InputReader.nextInt();
        }
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    /**
     * 快速排序
     *
     * @param array 数组
     * @param low   开始(范围包括）
     * @param high  结束（范围包括）
     */
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot;
            Stack<Integer> stack = new Stack<>();
            stack.push(low);
            stack.push(high);
            while (!stack.empty()) {
                // 先弹出high,再弹出low
                high = stack.pop();
                low = stack.pop();
                pivot = partition(array, low, high);
                // 先压low,再压high
                if (low < pivot - 1) {
                    stack.push(low);
                    stack.push(pivot - 1);
                }
                if (pivot + 1 < high) {
                    stack.push(pivot + 1);
                    stack.push(high);
                }
            }
        }

    }

    /**
     * 分区
     *
     * @param array 数组
     * @param low   开始(范围包括）
     * @param high  结束（范围包括）
     * @return 返回基准值位置，它的左边都比他小，右边都比他大
     */
    public static int partition(int[] array, int low, int high) {
        //随机选取枢轴
        int t = low + (int) (Math.random() * (high - low));
        //交换第一个位置和选中的随机枢轴
        if (array[t] != array[low]) {
            array[t] ^= array[low];
            array[low] ^= array[t];
            array[t] ^= array[low];
        }
        int pivot = array[low];
        while (low < high) {
            //从右往左找到比枢轴小的
            while (array[high] >= pivot && low < high) {
                high--;
            }
            array[low] = array[high];
            //从左往右找到比枢轴大的
            while (array[low] <= pivot && low < high) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }

    /**
     * 加速输入类，使用BufferReader比Scanner更加快
     */
    static class InputReader {
        private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer tokenizer = null;

        static String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
