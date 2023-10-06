package Sorting;

import java.util.Arrays;
import java.util.Scanner;

/*
In bubble sort you will look for the adjacent element, if it is gereater then current swap it,
So there will be n-1 rounds
In each round you will put one largest element at its correct position
    for eg, in round one 1st largest element will go to its correct element
    in round two 2nd largest will go and so on
 */
public class BubbleSort {
    public static void main(String[] args) {
// Creating Scanner Object for taking Inputs from the USER
        Scanner sc = new Scanner(System.in);
        // Take SIZE of 1D Array from the USER
        System.out.print(" Enter SIZE of 1D Array: ");
        int n = sc.nextInt();
        // Creating Array of Required SIZE
        int [] arr = new int[n];
        // Fill the Array by taking inputs from the USER
        System.out.print(" Enter " + n + " Elements: ");
        for(int i=0; i<arr.length; i++)
            arr[i] = sc.nextInt();
        // Display the Input Array Before Sorting
        System.out.println(" Array Before Sorting is: " + Arrays.toString(arr));
        // Apply Selection Sort
        bubbleSort(arr);
        // Display resultant Array (i.e Sorted Array) After Sorting
        System.out.println(" Array After Sorting is: " + Arrays.toString(arr));
    }

    /*

     */
    static void bubbleSort(int [] arr){

        boolean swap = true; // let keep a boolean
        for(int i=0; i< arr.length-1 ; i++){
            for(int j=0; j<arr.length-i-1; j++){ // every time one element will be placed at right place, so no need to go to end of
                //array evertime, reduce the array check by i
                if(arr[j]> arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //swap(arr,arr[j],arr[j+1] );
                    swap = false;
                }

            }
            if(swap)
                break;
        }
    }

}
