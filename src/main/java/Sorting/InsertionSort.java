package Sorting;

import java.util.Arrays;
import java.util.Scanner;

/*
This is a stable and adatable sorting algorithm
Consider this as playing cards, you will keep on inserting the card in correct order

Here we dont swap the elements but we SHIFT the elements
 */
public class InsertionSort {

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
        selectionSort(arr);
        // Display resultant Array (i.e Sorted Array) After Sorting
        System.out.println(" Array After Sorting is: " + Arrays.toString(arr));
    }

     static void selectionSort(int [] arr){

        for(int i=1; i< arr.length; i++){
            int temp = arr[i];
            int j=i-1;
            // 10 1 7 4 8 2 11
            for(; j>=0; j--){ // bcoz we check the j with previous elements
                if (arr[j]> temp){

                    arr[j+1] = arr[j];
                }else {
                    break; // here the element is already biger
                }


            }
            // now we made the shift but everytime we have to put the j to the next position hence lets make j global
            arr[j+1] = temp;
        }

    }

    static void optimizedSelectionSort(int []arr){
        /*
        this is clean way of writing the selection sort
         */
        for (int i=1; i< arr.length; i++){
            int temp = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = temp;

        }
    }
}
