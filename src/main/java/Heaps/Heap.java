package Heaps;

import java.util.*;

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
        if(left<=n && arr[largest]<arr[left]){
            largest = left;

        }
        if(right<=n && arr[largest]<arr[right]){
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

    private static void heapSort(int [] arr,int n){
        /*
        swap the first element and last element, bcoz the root will be largest
        now reduce the size by 1, bcoz last element is already sorted
        now arrange the first element in correct place(heapify)

         */
        int size = n;

        while(size >1){
            //step 1
            swapArrayValues(arr,arr[size],arr[1]);
            //step 2
            size--;
            //step 3
            heapify(arr,size,1);
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
        int n = 4;

        /*
        leaf nodes are the index (n/2+1) till nth, hence we dont need to process them
        as they are alreay heap,
        so we will start
         */
        for (int i = n/2; i>0;i--){
            heapify(arr,n,i);
        }
     //   h.print();

        //Heap sort
        heapSort(arr,n);
        System.out.println("Heap sort " );
        for(int i=1; i<=n;i++){
            System.out.println(arr[i]+ " ");
        }

        /*
        In java the priority queue is implemented by using the Min heap
         */
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        p.add(4);
        p.add(2);
        p.add(5);
        p.add(3);

        System.out.println("Top element of the heap is " + p.peek());
        //p.poll() this will remove the element from the priority queue

        /*
        if you want to change the position of the element you will need to use the comparator
        or change from Min to max heap
         */

        PriorityQueue<Integer> pMax = new PriorityQueue<Integer>(Comparator.reverseOrder());
        pMax.add(4);
        pMax.add(2);
        pMax.add(5);
        pMax.add(3);

        System.out.println(" elements of the Max heap are " + pMax);





    }
}
