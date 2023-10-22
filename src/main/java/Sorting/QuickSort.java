package Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8 , 9 , 2 , 5 , 1};
        int size = 5;

        System.out.println("Before Sorting");

        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        quicksort(arr,0,size-1);
        System.out.println("After Sorting");
        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void quicksort(int[] arr, int s, int e) {
        //base case
        if(s>=e)
            return;

        //Partition
        int p = partition(arr,s,e);

        //Recurssion
        //left part
        quicksort(arr,s,p-1);
        //right part
        quicksort(arr,p+1,e);

    }

    private static int partition(int[] arr, int s, int e) {
        int pivot = arr[s];

        //count no of element less then pivot
        int cnt = 0;
        for(int i=s+1;i<=e;i++){
            if (arr[i]<=pivot){
                cnt ++;
            }
        }

        //place pivot at right position
        int pivotIndex = s+cnt;
        swap(arr[pivotIndex],arr[s]);

        //left and right wala part sambhal lete hai

        int i=s, j=e;
        while(i<pivotIndex && j>pivotIndex){
            //jab tak left mai koi elment piviot se chota hai to chalega
            while (arr[i]<pivot){
                i++;
            }

            while (arr[j]>pivot){
                j--;
            }
            //else swap
            if(i<pivotIndex && j>pivotIndex){
                swap(arr[i],arr[j]);
                i++;
                j--;
            }

        }
        return pivotIndex;
    }

    static void swap(int i, int j) {
        int t = i;
        i = j;
        j = t;
    }
}
