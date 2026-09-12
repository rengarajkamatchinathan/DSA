package bst._2_medium;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Function to perform inorder traversal
    void inorderTraversal(Node root, List<Integer> arr) {
        // Base case
        if (root == null) return;
        // Traverse left subtree
        inorderTraversal(root.left, arr);
        // Store current node data
        arr.add(root.data);
        // Traverse right subtree
        inorderTraversal(root.right, arr);
    }

    // Function to merge two sorted lists
    List<Integer> mergeArrays(List<Integer> arr1, List<Integer> arr2) {
        // Initialize result list
        List<Integer> merged = new ArrayList<>();
        // Initialize pointers
        int i = 0, j = 0;
        // Merge until one list ends
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) merged.add(arr1.get(i++));
            else merged.add(arr2.get(j++));
        }
        // Add remaining elements
        while (i < arr1.size()) merged.add(arr1.get(i++));
        while (j < arr2.size()) merged.add(arr2.get(j++));
        return merged;
    }

    // Function to merge two BSTs
    List<Integer> mergeBSTs(Node root1, Node root2) {
        // Lists to store inorder traversals
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        // Perform inorder traversal
        inorderTraversal(root1, arr1);
        inorderTraversal(root2, arr2);
        // Merge and return
        return mergeArrays(arr1, arr2);
    }
}

public class _10_merge_two_bst {
    public static void main(String[] args) {
        // Create first BST
        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(5);

        // Create second BST
        Node root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(6);
    }
}
