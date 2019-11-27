package level2.mission7;

import java.util.Scanner;

/**
 * P1019 单词接龙
 *
 * @author ajacker
 * @date 2019/11/27 18:43
 */
public class P1019 {

    private static int n;
    private static String[] strs;
    private static int max = 0;
    /**
     * 可用次数
     */
    private static int[] count;
    private static char startChar;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        strs = new String[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
            count[i] = 2;
        }
        startChar = sc.next().charAt(0);
        dfs(null);
        System.out.println(max);
    }

    public static void dfs(String start) {
        //如果开头错误直接返回
        if (start != null && start.charAt(0) != startChar) {
            return;
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                //尝试拼接字符串
                String res = merge(start, strs[i]);
                if (res != null) {
                    flag = true;
                    count[i]--;
                    dfs(res);
                    count[i]++;
                }

            }
        }
        if (!flag) {
            max = Integer.max(start.length(), max);
        }
    }

    /**
     * 尝试在str1后面加str2 失败返回空字符串
     *
     * @param str1 开始
     * @param str2 结束
     * @return 成功返回合并后的字符串，失败返回null
     */
    public static String merge(String str1, String str2) {
        if (str1 == null) {
            return str2;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        //找到切入点
        int appendIndex = -1;
        //从后往前找，才能找到最长的拼接方式
        for (int i = len1 - 1; i >= 0; i--) {
            if (arr1[i] == arr2[0] && len1 - i < len2) {
                boolean flag = true;
                for (int j = 0; i + j < len1 && j < len2; j++) {
                    if (arr1[i + j] != arr2[j]) {
                        flag = false;
                    }
                }
                if (flag) {
                    appendIndex = i;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < appendIndex; i++) {
            sb.append(arr1[i]);
        }
        sb.append(arr2);
        if (appendIndex == -1 || sb.length() == len1 || sb.length() == len2) {
            return null;
        } else {
            return sb.toString();
        }
    }
}
