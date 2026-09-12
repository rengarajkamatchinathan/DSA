package binarytrees._3_hard;

import java.util.Map;

public class _8_costruct_bt_preord_inord {
    static Node construct(int preorder[], int prestart, int preend, int istart, int iend, Map<Integer, Integer> iMap){
        if(prestart>preend || istart>iend) return null;

        Node root = new Node(preorder[prestart]);
        int inordRoot = iMap.get(preorder[prestart]);
        int numsleftoniorder = inordRoot-istart;

        root.left = construct(preorder, prestart+1, prestart+numsleftoniorder, istart, inordRoot-1, iMap);
        root.right = construct(preorder, prestart+numsleftoniorder+1, preend, inordRoot+1, iend, iMap);

        return root;
    }
    public static void main(String[] args) {
        int pre[] = {3, 9, 20, 15, 7};
        int ino[] = {9, 3, 15, 20, 7};
    }
}
