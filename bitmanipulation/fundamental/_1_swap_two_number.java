package bitmanipulation.fundamental;

public class _1_swap_two_number {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        a = a ^ b;
        
        //now a already has b
        //so if again do ^b, it removes b. bcz both b's bit are same. 
        // since its xor same bits gives 0 different bits gives 1
        b = a ^ b;

        //a has a ^ b , 
        // our b has already a, if we do ^b then a gets removed
        a = a ^ b;

        /*
        a = a^b
        b = a^b = (a^b)^b = a
        a = a^b = (a^b)^a = b
        */


        System.out.println(a);
        System.out.println(b);
    }
}
