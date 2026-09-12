package binarytrees._3_hard;

import java.util.List;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}
public class _1_root_to_leaf_path {
    static boolean getPath(Node node, int t, List<Integer> res){
        if(node==null) return false;

        res.add(node.data);

        if(node.data==t) return true;

        if(getPath(node.left, t, res) || getPath(node.right, t, res)){
            return true;
        }

        //remove added node
        res.remove(res.size()-1);

        return false;
    }
    public static void main(String[] args) {
        
    }
}
