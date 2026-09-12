package binarytrees._3_hard;

import java.util.Map;

public class _9_costruct_bt_posord_inord {
    static Node construct(int posorder[], int posstart, int posend, int istart, int iend, Map<Integer, Integer> iMap){
        if(posstart>posend || istart>iend) return null;

        Node root = new Node(posorder[posend]);
        int inordRoot = iMap.get(posorder[posend]);
        int numsleftoniorder = inordRoot-istart;

        root.left = construct(posorder, posstart, posstart+numsleftoniorder-1, istart, inordRoot-1, iMap);
        root.right = construct(posorder, posstart+numsleftoniorder, posend-1, inordRoot+1, iend, iMap);

        return root;
    }
    public static void main(String[] args) {
        int pos[] = {40, 20, 50, 10, 60, 30};
        int ino[] = {40, 50, 20, 60, 30, 10};
    }
}
