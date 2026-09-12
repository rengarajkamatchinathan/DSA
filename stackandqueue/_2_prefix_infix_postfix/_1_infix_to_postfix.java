import java.util.Stack;

public class _1_infix_to_postfix {
    static int priority(char c){
        if(c=='+' || c=='-')return 1;
        else if(c=='/' || c=='*')return 2;
        else if(c=='^') return 3;

        return -1;
    }
    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        //op: abcd^e-fgh*+^*+i-

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

        System.out.println(res);
    }    
}