package sort;

import sort.util.InitArr;
import sort.util.Print;

/**
 * 堆排序
 * <p>
 * 左子节点位置：2*i + 1
 * 右子节点位置：2*i + 2
 * 父节点位置：(i - 1) / 2
 */
public class Sort7_Heap {

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
        // 创建大堆
        for (int i = 0; i < arr.length; i++) {
            build(arr, i);
        }

        // 最大数放末尾，然后缩小堆范围，最后调整堆结构(保持大堆结构)
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
    }

    /**
     * 构建大堆
     */
    private static void build(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 调整堆，保持大堆状态
     */
    private static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            int right = left + 1;
            int last = right < size && arr[right] > arr[left] ? right : left;
            last = arr[index] > arr[last] ? index : last;
            if(last == index) {
                // 若当前节点大于左右子节点，则认为依然是大堆状态，无需调整
                break;
            }
            swap(arr, index, last);
            index = last;
            left = 2 * index + 1;
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
    }


}
