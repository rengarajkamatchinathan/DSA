import java.util.Stack;

public class _3_postfix_to_infix {
    public static void main(String[] args) {
        String postfix = "ab+c*";
        //(a+b)*c

        Stack<String> st = new Stack<>();

        for(int i=0;i<postfix.length();i++){
            char c = postfix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                st.push(String.valueOf(c));
            }
            else{
                String b = st.pop();
                String a = st.pop();
                st.push("("+b+c+a+")");
            }
        }

        System.out.println(st.peek());
    }
}
