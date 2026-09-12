import java.util.Stack;

public class _5_postfix_to_prefix {
    public static void main(String[] args) {
        String postfix = "abc*+d-";
        // -+a*bcd

        Stack<String> st = new Stack<>();

        for(int i=0;i<postfix.length();i++){
            char c = postfix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                st.push(String.valueOf(c));
            }
            else{
                String b = st.pop();
                String a = st.pop();
                st.push(c+a+b);
            }
        }

        System.out.println(st.peek());
    }
}
