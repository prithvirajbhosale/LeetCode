package Trees;

import java.util.*;

public class LRUCache {

    public static int getMinimumSize(List<String> requests, int k) {
        if (requests == null || requests.isEmpty() || k <= 0) {
            return -1;
        }

        Map<String, Integer> cacheMap = new HashMap<>();
        LinkedList<String> cacheList = new LinkedList<>();

        int cacheHits = 0;

        for (int i = 0; i < requests.size(); i++) {
            String currentItem = requests.get(i);

            if (cacheMap.containsKey(currentItem)) {
                cacheList.remove(currentItem);
                cacheList.addFirst(currentItem);
                cacheHits++;

                if (cacheHits == k) {
                    return cacheList.size();
                }
            } else {
                if (cacheList.size() == k) {
                    String leastRecentlyUsed = cacheList.removeLast();
                    cacheMap.remove(leastRecentlyUsed);
                }

                cacheMap.put(currentItem, i);
                cacheList.addFirst(currentItem);
            }
        }

        return cacheList.size();
    }

    public static void main(String[] args) {
        List<String> requests = Arrays.asList("item1", "item1", "item3", "item1", "item3");
        int k = 1;
        int result = getMinimumSize(requests, k);
        System.out.println("Minimum Size: " + result);
    }
}

