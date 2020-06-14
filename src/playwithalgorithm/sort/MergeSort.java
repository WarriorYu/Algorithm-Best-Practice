package playwithalgorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        Comparable[] arr = {1,7,2,5,9,7,8,6};
        new MergeSort().sort(arr);
    }
    public void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    private void sort(Comparable[] arr, int l,int r) {
        if (l>=r) return;
        int mid = l+(r-l)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] temp = Arrays.copyOfRange(arr,l,r+1);

        int i = l,j = mid+1;
        for (int k = l; k <= r; k++) {
            if(i>mid){
                arr[k] = temp[j-l];
                j++;
            }else if(j>r){
                arr[k] = temp[i-l];
                i++;
            }else if(temp[i-l].compareTo(temp[j-l])<0){
                arr[k] = temp[i-l];
                i++;
            }else {
                arr[k] = temp[j-l];
                j++;
            }
        }

    }
}
