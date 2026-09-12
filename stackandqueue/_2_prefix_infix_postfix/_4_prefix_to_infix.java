import java.util.Stack;

public class _4_prefix_to_infix {
    public static void main(String[] args) {
        String prefix = "*+ab-cd";
        // ((a+b)*(c-d))

        
        //reverse prefix then prev problem
        prefix = new StringBuilder(prefix).reverse().toString();

        Stack<String> st = new Stack<>();

        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);

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
