package sort;

import sort.util.InitArr;
import sort.util.Print;

/**
 * 希尔排序（特殊的插入排序）
 */
public class Sort4_Shell {

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

        // 初始化最大间隔,公式是循环 h = h * 3 + 1,后续减少间隔反向运算
        int h = 1;
        while (h < len / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            // 从间隔开始遍历
            for (int i = h; i < len; i++) {
                // 待插入数据temp
                int temp = arr[i];
                // 插入下标index
                int index = i;
                // 以 h 间隔 依次比较 前面排好的间隔为 h 的有序数组
                for (int y = index - h; y >= 0; y -= h) {
                    // 当前 y对应值 大于 待插入值 则 y对应值 右移,并设置插入下标为 y
                    if (arr[y] > temp) {
                        arr[y + h] = arr[y];
                        index = y;
                    } else {
                        break;
                    }
                }
                // 若发生右移，则将 待插入值 插入数组
                if (index != i) {
                    arr[index] = temp;
                }
            }
            // 减少间隔，反推公式
            h = (h - 1) / 3;
        }
    }
}
