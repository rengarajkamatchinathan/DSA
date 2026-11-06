package bitmanipulation.problems;

public class _1_min_bit_flips_to_convertNumber {
    public static void main(String[] args) {
        int start = 10;
        int goal = 7;

        //1010 -> 0111 
        //op = 3

        //1010
        //0111

        int num = start^goal;
        //now same 1s become 0 and corresponding 1 with 0 will be moved down.
        //consider each 1 as each operation of flip
        //moving start's 1 to down means we're removing it hypothtically
        //likewise moving goals 1 down, mean we're updating it

        //now cnt bits
        int cnt = 0;
        while (num!=0) {
            num = (num & (num-1));
            cnt++;
        }

        System.out.println(cnt);
    }
}
