package bitmanipulation.fundamental;

public class _6_remove_last_set_bit {
    public static void main(String[] args) {
        int n = 40;
        //101000
        //100111 (39)
        // ----------

        //while n-1 we're borrowing nearest 1 from right side. 
        //then 0's become 1's and borrowed 1 become 0.
        
        n = n&(n-1);
    }
}
