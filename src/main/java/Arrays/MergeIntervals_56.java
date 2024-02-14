package Arrays;

import java.util.*;

public class MergeIntervals_56 {

        public static int[][] merge(int[][] intervals) {
                 /*
            Sort the arrays, it will make easy to understand the overlapping
            keep a start point at 0 0
            keep interval end at  0 1
            now start iterating from second interval and check
                if the start of the new interval is greater that end interval
                if not then merge
           */

            Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

            int totalIntervals = intervals.length;

            int in_start = intervals[0][0];
            int in_end = intervals[0][1];

            List<int[]> ans = new ArrayList<>();


            for(int i=1; i<totalIntervals; i++){

                if(intervals[i][0]> in_end){
                    ans.add(new int[] {in_start,in_end});

                    in_start = intervals[i][0];
                    in_end = intervals[i][1];

                }else{
                    in_end = Math.max(in_end,intervals[i][1]) ;
                }

            }
            ans.add(new int[] {in_start, in_end});
            return ans.toArray(new int[ans.size()][]);
        }

    public static void main(String[] args) {
        int [][] arr = {{1,3},{2,6},{8,10},{15,18}};
        merge(arr);
    }

}
