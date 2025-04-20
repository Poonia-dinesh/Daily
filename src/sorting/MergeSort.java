package sorting;


import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int arr[] = {9,4,7,6,3,1,5};

        int[] ansarr = new int[arr.length];
        mergeSort(ansarr,arr, 0, arr.length-1);
        for(int a : arr) System.out.println(a);
    }

    public static void mergeSort(int[] ansarr, int[] arr, int l , int r){
        if(l < r){
        int mid = (l+r)/2;
            mergeSort(ansarr, arr, l, mid);
            mergeSort(ansarr, arr, mid+1, r);
            merge(ansarr, arr, l, mid, r);
            for(int k = l; k<=r; k++){
                arr[k] = ansarr[k];
            }
    }

    }

    private static void merge(int[] tarr, int[] arr, int l, int mid, int r) {
         int i =l;
         int j = mid+1;
         int k = l;

         while (i <= mid && j <= r){
             if(arr[i] <= arr[j]){
                 tarr[k++] = arr[i++];
             }
             else {
                 tarr[k++] =  arr[j++];
             }
         }

             while (i<=mid){
                 tarr[k++] = arr[i++];
         }
             while (j <= r){
                 tarr[k++] = arr[j++];
         }
    }
}
