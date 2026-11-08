
public class _1_valid_parenthesis {
    static boolean check(String s){
        int min = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(') {
                min++;
                max++;
            }
            else if (s.charAt(i)==')') {
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }

            if(min<0) min = 0;

            //equivalent to cnt becomes -1
            if(max<0) return false;
        }

        //what if u have '(' alone then range be 1,1
        return min==0;
    }
    public static void main(String[] args) {
        String s = "(*))";
    }
}
