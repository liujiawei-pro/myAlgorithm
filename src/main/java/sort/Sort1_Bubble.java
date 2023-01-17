package sort;

import sort.util.InitArr;
import sort.util.Print;

/**
 * 冒泡排序
 */
public class Sort1_Bubble {

    public static void main(String[] args) {

        int[] arr = InitArr.init(10);
        Print.out("排序前：", arr);

        sort(arr);

        Print.out("排序后：", arr);

    }

    /**
     * 从小到大
     */
    public static void sort(int[] arr) {
        int len = arr.length;
        //从左至右遍历
        for (int i = 0; i < len; i++) {
            // 从右至左遍历
            for (int y = len - 1; y > i; y--) {
                // 若 ‘后’ 小于 ‘前’ 则将 ‘后’ 的冒到前面
                if (arr[y - 1] > arr[y]) {
                    // 异或
                    arr[y - 1] = arr[y - 1] ^ arr[y];
                    arr[y] = arr[y - 1] ^ arr[y];
                    arr[y - 1] = arr[y - 1] ^ arr[y];
                }
            }
        }
    }
}
