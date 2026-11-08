
public class _8_CheckNumber_is_oddoreven {
    public static void main(String[] args) {
        int n = 13;
        //1101

        //int n = 12;
        //1100
        
        //int n = 40;
        //101000
        //100111 (39)

        //odd number last bit have to be 1 , if its 0 then its even number
        if ((n&1)==1) {
            System.out.println("odd");
        }else{
            System.out.println("even");
        }
    }
}
