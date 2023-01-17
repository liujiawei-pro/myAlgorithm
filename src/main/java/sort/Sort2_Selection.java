package sort;

import sort.util.InitArr;
import sort.util.Print;

/**
 * 选择排序
 */
public class Sort2_Selection {

    public static void main(String[] args) {

        int[] arr = InitArr.init(15);
        Print.out("排序前：", arr);

        sort(arr);

        Print.out("排序后：", arr);

    }

    /**
     * 从小到大
     */
    public static void sort(int[] arr) {
        int len = arr.length;
        // 从左至右遍历
        for (int i = 0; i < len - 1; i++) {
            // 假设最小值下标为i
            int min = i;
            // y从i的下一位开始遍历
            for (int y = i + 1; y < len; y++) {
                // 若‘min对应值’大于‘当前下标对应值’则‘当前下标’为最小
                if (arr[min] > arr[y]) {
                    min = y;
                }
            }
            // 将最小下标值与当前i值交换
            if (min != i) {
                arr[i] = arr[i] ^ arr[min];
                arr[min] = arr[i] ^ arr[min];
                arr[i] = arr[i] ^ arr[min];
            }
        }
    }
}
