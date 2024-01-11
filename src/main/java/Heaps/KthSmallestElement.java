package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Pefect solution but we can do it with heaps

      /* Arrays.sort(arr);
       return arr[k-1];
       */

        /*
        Approach 2

        create a Max heap and only push k elements

        Now put the remaining elements in Heap only if
            Element < heap.top

        At the end your heap top will have the kth smallest element that you want

        we created Max heap so that smallest stays at the top
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            //Step 1
        for (int i=0;i<k;i++){
        pq.add(arr[i]);
        }

        //step 2

        for (int i =k; i< r; i ++){
            if(arr[i]<pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }


        //Setep 3
        // ans is equal to top of the heap

        return pq.peek();
    }
}
