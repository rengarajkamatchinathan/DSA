package bst._2_medium;

public class _8_construct_bst_preorder {
    static Node construct(int preorder[], int i[], int bound){
        if (i[0]==preorder.length || preorder[i[0]]>bound) {
            return null;
        }

        Node node = new Node(preorder[i[0]]);
        i[0]++;
        node.left = construct(preorder, i, node.data);
        node.right = construct(preorder, i, bound);

        return node;
    }
    public static void main(String[] args) {
        int preorder[] = {8,5,1,7,10,12};
        Node node = construct(preorder, preorder, 0);
    }
}
