package bitmanipulation.fundamental;

public class _7_check_if_power_of_2 {
    public static void main(String[] args) {
        int n = 16;
        //yes, 2 pow 4 = 16
        
        //int n = 15;
        //no
        
        //10000
        if ((n & (n-1))==0) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
