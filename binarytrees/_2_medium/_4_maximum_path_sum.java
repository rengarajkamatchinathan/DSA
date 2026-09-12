package binarytrees._2_medium;


class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}
public class _4_maximum_path_sum {
    static int maxVal = 0;
    static int height(Node node){
        if(node==null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        
        maxVal = Math.max(maxVal, left+right+node.data);

        return Math.max(left, right)+node.data;
    }
    public static void main(String[] args) {
        
    }   
}
