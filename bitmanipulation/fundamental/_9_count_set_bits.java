
public class _9_count_set_bits {
    public static void main(String[] args) {
        int num = 39; 
        // 100111
        //op = 4

        int cnt = 0;
        while (num!=0) {
            num = (num & (num-1));
            cnt++;
        }

        System.out.println(cnt);
    }
}
