import java.util.Stack;

public class _2_infix_to_prefix {
    public static void main(String[] args) {
        String infix = "x+y*z/w+u";
        //++x/*yzwu

        //1.reverse & swap brackets
        String rev = "";
        for(int i=infix.length()-1;i>=0;i--){
            if (infix.charAt(i)=='(') {
                rev += ')';
            }else if (infix.charAt(i)==')') {
                rev += '(';
            }else{
                rev += infix.charAt(i);
            }
        }

        //2.Apply postfix
        String postfix = postfix(infix);

        //3.Postfix
        String res = new StringBuilder(postfix).reverse().toString();
        
        System.out.println(res);
    }

    static String postfix(String infix){
        String res = "";
        Stack<Character> stack = new Stack<>();

        for(char c:infix.toCharArray()){
            if (Character.isLetterOrDigit(c)) {
                res+=c;
            }
            else if(c=='('){
                stack.push(c);
            }
            else if(c==')'){
                while (!stack.isEmpty() && stack.peek()!='(') {
                    res+=stack.pop();
                }
                stack.pop();
            }
            else{
                while (!stack.isEmpty() && priority(c)<=priority(stack.peek())) {
                    res+=stack.pop();
                }
                stack.push(c);
            }
        }

        return res;
    }

    static int priority(char c){
        if(c=='+' || c=='-')return 1;
        else if(c=='/' || c=='*')return 2;
        else if(c=='^') return 3;

        return -1;
    }
}