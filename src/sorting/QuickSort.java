package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int arr[]  = {5,1,9,10,2,13};
        quickSortt(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out :: println);
    }

    public static void quickSortt(int[] arr, int l, int h){
        if(l<h){
            int pivot = partation(arr, l, h);
            quickSortt(arr, l, pivot-1);
            quickSortt(arr, pivot+1, h);
        }
    }

    public static int partation(int[] arr, int l, int h){
        int pivot = arr[l];
        int i = l;
        int j = h;
        while(i<j) {
            while (arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
                int temp = arr[l];
                arr[l] = arr[j];
                arr[j] = temp;
                return j;
        }


}
