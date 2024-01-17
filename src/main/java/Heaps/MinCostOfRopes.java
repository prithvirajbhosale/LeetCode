package Heaps;

import java.util.PriorityQueue;

public class MinCostOfRopes {

    public static void main(String[] args) {
        long arr[] = new long[]{4, 3, 2,6};
        int n = 4;

        long ans = minCost(arr,n);
        System.out.println("Minimum cost is " + ans);
    }

        //Function to return the minimum cost of connecting the ropes.
        static long minCost(long arr[], int n)
        {
        /*
        keep on adding the minimum values in the array
            We can use Min heap
        Append this sum back to array and keep repeating
            Pop from the queue
            add to sum variable
            Push this sum back to queue

        */



            PriorityQueue<Long> pq = new PriorityQueue<>();

            for (long l : arr) {
                pq.add(l);
            }
            pq.forEach(System.out::println);

            long cost = 0;
            while (pq.size()>1){
                long a = pq.peek();
                pq.poll();

                long b = pq.peek();
                pq.poll();

                long sum = a+b;
                cost += sum;

                pq.add(sum);
            }


           return cost;


        }

}
