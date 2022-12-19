/*
 * Реализовать алгоритм сортировки слиянием
 */

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] sortArr) {
        int[] num1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] num2 = new int[sortArr.length];
        int[] result = mergeSortInner(num1, num2, 0, sortArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] num1, int[] num2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return num1;
        }

        // уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(num1, num2, startIndex, middle);
        int[] sorted2 = mergeSortInner(num1, num2, middle, endIndex);

        // слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == num1 ? num2 : num1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++]
                    : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    public static void main(String args[]) {
        int[] sortArr = { 75, 67, 65, 15, 68, 64, 63, 62, 61 };
        int[] result = mergeSort(sortArr);

        System.out.println("До сортировки\n" + Arrays.toString(sortArr));
        System.out.println("После сортировки:\n" + Arrays.toString(result));
    }
}