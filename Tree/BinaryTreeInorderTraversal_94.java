package Tree;

public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current must be null at this point, so we pop from the stack
            current = stack.pop();
            result.add(current.val); // Add the node's value to the result

            // We have visited the node and its left subtree. Now, it's right subtree's turn
            current = current.right;
        }

        return result;
    }
}
