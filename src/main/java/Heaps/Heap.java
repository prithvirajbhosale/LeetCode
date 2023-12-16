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

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(52);
        h.insert(54);
        h.print();
        System.out.println();

        h.deleteFromHeap();
        h.print();
    }
}
