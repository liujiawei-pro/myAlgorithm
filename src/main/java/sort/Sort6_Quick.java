package sort;

import sort.util.InitArr;
import sort.util.Print;

/**
 * 快速排序（分治法算法思想）
 */
public class Sort6_Quick {

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
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 左指针
        int p1 = left;
        // 右指针
        int p2 = right;
        // 参考数(可以优化为随机取一个范围内的数)
        int mid = arr[left];

        while (p1 < p2) {
            while (p1 < p2 && arr[p2] > mid) {
                // 右边指针往左移动，直到找到小于参考值的数
                p2--;
            }
            if (p1 < p2) {
                // 右边小于参考值的数拷贝到左边
                arr[p1++] = arr[p2];
            }
            while (p1 < p2 && arr[p1] < mid) {
                // 左边指针往右移动，直到找到大于参考值的数
                p1++;
            }
            if (p1 < p2) {
                // 右边小于参考值的数拷贝到左边
                arr[p2--] = arr[p1];
            }
        }
        // 参考数拷贝到中间
        arr[p1] = mid;
        quickSort(arr, left, p1 - 1);
        quickSort(arr, p1 + 1, right);
    }
}
