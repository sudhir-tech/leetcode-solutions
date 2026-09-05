package Tree;

import javax.swing.tree.TreeNode;

public class RecoverBST99 {
    class Solution {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        // Swap the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        // Detect violation
        if (prev != null && prev.val > node.val) {

            if (first == null) {
                first = prev;
            }

            second = node;
        }

        prev = node;

        inorder(node.right);
    }
}
}
