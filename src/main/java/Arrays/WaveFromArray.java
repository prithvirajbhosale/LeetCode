package Arrays;
/*Given an unsorted array of integers, sort the array into a wave array. An array arr[0..n-1] is sorted in wave form if:
        arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= */


import java.util.Arrays;

public class WaveFromArray {

    public static void convertToWave(int n, int[] a) {
        // code here
        Arrays.sort(a);

        /* iteration
        //12345
        // i ->0,1
        //2,1
        // i -> 2
        //2,1,4,3,5
        */


        for(int i =0; i<n-1; i=i+2){
            swap(a,i,i+1);
        }

    }

    private static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b] = temp;

    }
}
