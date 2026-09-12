    package stackandqueue._3_monotonic_stack;

    import java.util.Stack;

    public class _9_remove_k_digits {
        public static void main(String[] args) {
            String num = "1432219";
            int k = 3;
            // Output: "1219"
            // Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

            Stack<Character> st = new Stack<>();

            for (int i = 0; i < num.length(); i++) {

                char current = num.charAt(i);

                while (!st.isEmpty() && st.peek() > current && k > 0) {
                    st.pop();
                    k--;
                }

                st.push(current);
            }


            while (k>0) {
                k--;
                st.pop();
            }

            String res = "";
            while (!st.isEmpty()) {
                res+=st.pop();
            }

            System.out.println(new StringBuilder(res).reverse());
        }
    }
