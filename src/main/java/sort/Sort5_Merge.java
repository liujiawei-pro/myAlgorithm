package sort;

import sort.util.InitArr;
import sort.util.Print;

/**
 * 归并排序
 */
public class Sort5_Merge {

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
        split(arr, 0, arr.length - 1);
    }

    /**
     * 拆分
     */
    private static void split(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        // 取中点，防止越界
        int mid = left + ((right - left) >> 2);
        split(arr, left, mid);
        split(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * 归并
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // 左指针
        int p1 = left;
        // 右指针
        int p2 = mid + 1;
        // 临时数组
        int[] temp = new int[right - left + 1];
        // 临时数组指针
        int p3 = 0;
        while (p1 <= mid && p2 <= right) {
            temp[p3++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 剩余部分填充
        while (p1 <= mid) {
            // 左边剩余
            temp[p3++] = arr[p1++];
        }
        while (p2 <= right) {
            // 右边剩余
            temp[p3++] = arr[p2++];
        }
        // 回写
        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
