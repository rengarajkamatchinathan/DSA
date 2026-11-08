
import java.util.TreeMap;

public class _7_hands_of_straights {
    static boolean soln(int hand[], int grpsize){
        if(hand.length%grpsize!=0)return false;

        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            freq.put(hand[i], freq.getOrDefault(hand[i], 0) + 1);
        }

        while (!freq.isEmpty()) {
            int start = freq.firstKey();
            int count = freq.get(start);

            for(int i=0;i<grpsize;i++){
                int card = start + i;
                //check if this card exist. cuz consecutive
                //even exist, what if cnt is less
                //lets say 2 3's .next you want 2 4's , right?
                if(!freq.containsKey(card) || freq.get(card)<count) return false;

                //Decrease
                if(freq.get(card)==count){
                    freq.remove(card);
                }else{
                    //2-2, 3-2, 4-3, 5-1, 6-1
                    //here we removed 2 and 3 totally bcz of count 2 same.
                    //but 4 has 3 count. possibly it might form new grp next
                    freq.put(card, freq.get(card) - count);
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        // Output :  True
        
    }
}
