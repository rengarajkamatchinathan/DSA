package greedy.easy;

public class _3_lemonade_change {
    static boolean lemonade_change(int bills[]){
        int fives = 0;
        int tens = 0;
        for(int change:bills){
            if(change==5){
                fives++;
            }
            else if(change == 10){
                if (fives>0) {    
                    fives--;     
                    tens++;  
                }else{
                    return false;
                }
            }
            else{
                if (tens>0 && fives>0) {
                    tens--;
                    fives--;
                }
                else if(fives>=3){
                    fives -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        // Output: True
    }
}
