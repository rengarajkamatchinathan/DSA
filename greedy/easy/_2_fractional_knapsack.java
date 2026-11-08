
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Item{
    int wt;
    int val;
    Item(int wt, int val){
        this.wt = wt;
        this.val = val;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "wt = "+wt+" and val = "+val;
    }
}
public class _2_fractional_knapsack {
    static class ItemComparator implements Comparator<Item>{
        public int compare(Item a, Item b){
            double ratio1 = (double) a.val / a.wt;
            double ratio2 = (double) b.val / b.wt;
            return Double.compare(ratio2, ratio1);
        }
    }
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30}; 
        int capacity = 50;  

        // Output:
        //  240.000000 

        // Explanation:
        // - Take item 0 (w = 10, v = 60)  
        // - Take item 1 (w = 20, v = 100)  
        // - Take 2⁄3 of item 2 (w = 20, v = 80)  
        // Total value = 60 + 100 + 80 = 240

        Item[] items = new Item[wt.length];
        for(int i=0;i<wt.length;i++){
            items[i] = new Item(wt[i], val[i]);
        }

        //SORT based on weight - value ratio
        Arrays.sort(items, new ItemComparator());
        System.out.println(Arrays.toString(items));

        double tot = 0;
        for(Item it:items){
            if (it.wt<=capacity) {
                capacity -= it.wt;
                tot += it.val;
            }else{
                int remain = capacity;
                tot += ((double) (it.val/it.wt)) * remain;
                break;
            }
        }

        System.out.println(tot);
    }
}
