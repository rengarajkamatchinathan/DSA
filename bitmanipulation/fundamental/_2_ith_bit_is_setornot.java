package bitmanipulation.fundamental;

public class _2_ith_bit_is_setornot {
    public static void main(String[] args) {
        int num = 4;
        //(0100)
        int i = 2;

        //0100
        //0100

        if ((num & (1 << i))!= 0) {
            System.out.println("SET");
        }else{
            System.out.println("NOT SET");
        }
    }
}
