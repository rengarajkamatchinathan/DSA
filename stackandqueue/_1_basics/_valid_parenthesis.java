package stackandqueue._1_basics;

import java.util.Stack;

public class _valid_parenthesis {
    public static void main(String[] args) {
        // String str = "()";
        String str = "()[]{)";

        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for(char c:str.toCharArray()){
            if (c=='('||c=='{'||c=='[') {
                stack.push(c);
            }else{
                char match = stack.pop();
                if (c==')' && match!='(') {
                        flag=false;
                        break;
                }
                else if (c=='}' && match!='{') {
                        flag=false;
                        break;                    
                }
                else if (c==']' && match!='[') {
                        flag=false;
                        break;
                }
            }
        }

        System.out.println(flag);
    }
}
