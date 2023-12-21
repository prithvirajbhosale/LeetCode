package Heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Heap {

    int arr[] = new int[100];
    int size = 0;

    public Heap() {
        arr[0] = -1;

    }

    private void insert (int val){
        /*
            insert karne ke liye size ko phele bada do
            then insert the value in the size index
            abhi usko sahi jagah leke jao
                calculate parent
                check if parent is < the new array element
                    if yes iska matalb parent galat jagah hai toh swap karo
                    if no toh sahi jagah hai return karo
         */
        size = size +1;
        int index = size;
        arr[index] = val;

        while(index >1){
          //calculate the parent node

          int parent = index/2;
          //for max heap check the condition
          if(arr[parent] < arr[index]){
              List<int[]> list = Arrays.asList(arr);
              swapArrayValues(arr,arr[parent],arr[index]);
              index = parent;
          }else{
              return;
          }
        }

    }

    private void print(){
        for(int i=1; i<=size;i++){
            System.out.println(arr[i]+ " ");
        }

    }

    private void deleteFromHeap(){
        if (size == 0){
            System.out.println("Nothing to delete");
            return;
        }
        // 1 put last node in the first or node to be deleted
        arr[1] = arr[size];
        size --;

        //2 take root node to its correct pos
        int i =1;
        while (i<size){
            int leftIndex = 2*i;
            int rigthIndex = 2*i +1;
        //3 now compare it left and right index
            if(leftIndex <size && arr[i] < arr[leftIndex]){
                swapArrayValues(arr,arr[i],arr[leftIndex]);
                i = leftIndex;
            }else if (rigthIndex < size && arr[i]<rigthIndex){
                swapArrayValues(arr,arr[i],arr[rigthIndex]);
                i = rigthIndex;
            }else {
                return;
            }
        }
    }

    private static void swapArrayValues(int[] array, int value1, int value2) {
        int index1 = -1;
        int index2 = -1;

        // Find indices of the values in the array
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value1) {
                index1 = i;
            } else if (array[i] == value2) {
                index2 = i;
            }
        }

        // Check if both values are present in the array
        if (index1 != -1 && index2 != -1) {
            // Swap values
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        } else {
            System.out.println("One or both values not found in the array.");
        }
    }

    /*

     */
    private static void heapify(int arr[],int n, int i){
        int largest = i;
        int left = 2*i;
        int right = 2*i+1;

        //if largest is small then the left then change the largest
        if(left<n && arr[largest]<arr[left]){
            largest = left;

        }
        if(right<n && arr[largest]<arr[right]){
            largest = right;

        }

        //check if largest is updated, that means it is not equal to i
        //If it is updated that means node ko sahi jagah par paucha diya
        if(largest!=i){
        swapArrayValues(arr, arr[largest],arr[i]);
        //Now you should do this same for entire tree so call hepify
            heapify(arr,n,largest);
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(52);
        h.insert(54);
        h.print();
        System.out.println();

       // h.deleteFromHeap();
       // h.print();

        int[] arr = new int[]{-1,54,53,52,50};
        int n = 5;
        for (int i = n/2; i>0;i--){
            heapify(arr,n,i);
        }
        h.print();
    }
}
