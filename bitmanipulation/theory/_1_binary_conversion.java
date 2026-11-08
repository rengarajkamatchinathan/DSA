
public class _1_binary_conversion {
    static String dectobin(int num){
        String res = "";

        while (num>1) {
            res += num%2;
            num = num/2;
        }

        res += num;

        return new StringBuilder(res).reverse().toString();
    }
    static int bintodec(String num){
        int res = 0;
        for(int i=0;i<num.length();i++){
            int digit = num.charAt(num.length()-i-1) - '0';
            res += digit * Math.pow(2, i);
        }
        return res;
    }
    public static void main(String[] args) {
        int num = 4;

        System.out.println(dectobin(num));
        System.out.println(bintodec(dectobin(num)));
    }
}
