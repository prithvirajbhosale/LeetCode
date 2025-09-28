import java.util.HashSet;
import java.util.Random;

public class GetRandom {


    public HashSet<Integer> randomSet;
        public Random random;
        public GetRandom() {
            randomSet = new HashSet<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if(randomSet.contains(val)) return false;
            randomSet.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!randomSet.contains(val)) return false;
            randomSet.remove(val);
            return true;

        }

        public int getRandom() {
            Integer[] arrayNumbers = randomSet.toArray(new Integer[randomSet.size()]);
            return arrayNumbers[random.nextInt(randomSet.size())];
        }

    public static void main(String[] args) {
        GetRandom getRandom = new GetRandom();
        getRandom.insert(1);
        getRandom.remove(2);
        getRandom.insert(2);
        System.out.println(getRandom.getRandom());
    }



}
