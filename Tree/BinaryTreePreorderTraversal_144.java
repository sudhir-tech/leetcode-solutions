package Tree;

public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val); // Visit the root
        preorderHelper(node.left, result); // Traverse left subtree
        preorderHelper(node.right, result); // Traverse right subtree
    }
}
