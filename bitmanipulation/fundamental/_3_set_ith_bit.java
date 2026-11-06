package bitmanipulation.fundamental;

public class _3_set_ith_bit {    
    public static void main(String[] args) {
        int n = 9;
        int i = 2;
        //op = 13

        n = (n | (1<<i));

        System.out.println(n);
    }
}