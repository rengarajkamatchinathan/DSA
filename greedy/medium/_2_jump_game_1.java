package greedy.medium;

public class _2_jump_game_1 {
    static boolean soln(int jumps[]){
        //Flag to check each index reachable by previous steps
        //basically from previous index steps we're maintaining max index we're covering
        //what if the current index not covered under previous steps. so no way to jumped hear
        int maxInd = 0;

        for (int i = 0; i < jumps.length; i++) {
            if (i>maxInd) {
                return false;
            }
            maxInd = Math.max(maxInd, i+jumps[i]);
        }

        return true;
    }
    public static void main(String[] args) {
        int jumps[] = {2, 3, 1, 0, 4};
    }
}
