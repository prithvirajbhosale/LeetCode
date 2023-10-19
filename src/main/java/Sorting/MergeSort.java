package Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8 , 9 , 2 , 5 , 1};
        int size = 5;

        System.out.println("Before Sorting");

        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        mergeSort(arr,0,size-1);
        System.out.println("After Sorting");
        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeSort(int[] arr, int s, int e) {

        int mid = s + (e-s)/2;

        //base case
        while(s>=e){
            return;
        }
        // sort the first part
        mergeSort(arr,s,mid);

        //sort the second part
        mergeSort(arr,mid+1,e);

        merge(arr,s,e);




    }

    private static void merge(int[] arr, int s, int e) {
        int mid = (s + e)/2;

        // length of the new arrays to be created
        int length1 = mid - s +1;
        int length2 = e - mid;

        //create 2 new arrays to copy the element
        int first [] = new int[length1];
        int second [] = new int[length2];


        //copy all the elements
        int originalArrayIndex = s;
        for(int i=0; i<length1;i++){
            first[i] = arr[originalArrayIndex++];
        }

        for(int i=0; i<length2;i++){
            second[i] = arr[originalArrayIndex++];
        }
        originalArrayIndex = s;


        // now merge this 2 sorted arrays
        int idx1=0;
        int idx2=0;
        while (idx1< length1 && idx2< length2){

            if(first[idx1]< second[idx2]){
                arr[originalArrayIndex ++] = first[idx1++];
            } else {
                arr[originalArrayIndex++] = second[idx2++];
            }
        }

        // if the lengths are not equal there can be some elements remaining then copy all those elements

        //if in arr1 elements are remaining
        while(idx1 < length1){
            arr[originalArrayIndex++] = first[idx1++];
        }
        //if in arr2 elements are remaining
        while(idx2 < length2){
            arr[originalArrayIndex++] = second[idx2++];
        }




    }
}
