package bitmanipulation.fundamental;

public class _5_toggle_ith_bit {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        // 1101 -> 1001 
        //if toggle again 1001 -> 1101
        
        //even if move 1 to left side 
        //if we perform AND gives 1 for 1 and 1
        //likewise for OR gives 1 for 1 or 1
        //if we use XOR gives 0 for 1 XOR 1, also for other bits wont be same right?
        n = (n ^ (1<<i));
    }
}
