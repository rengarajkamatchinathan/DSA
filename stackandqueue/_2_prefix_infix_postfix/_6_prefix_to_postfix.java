import java.util.Stack;

public class _6_prefix_to_postfix {
    public static void main(String[] args) {
        String prefix = "*+ab-cd";
        //  ab+cd-*

        Stack<String> st = new Stack<>();

        for(int i=prefix.length()-1;i>=0;i--){
            char c = prefix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                st.push(String.valueOf(c));
            }
            else{
                String b = st.pop();
                String a = st.pop();
                st.push(b+a+c);
            }
        }

        System.out.println(st.peek());
    }
}
