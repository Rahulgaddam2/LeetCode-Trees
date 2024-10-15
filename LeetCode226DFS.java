package Trees;

public class LeetCode226DFS {

    public static void main(String[] args) {

        LeetCode226DFS Object = new LeetCode226DFS();

        
        TreeNode root = Object.new TreeNode(1);
        root.left = Object.new TreeNode(2);
        root.right = Object.new TreeNode(3);
        root.left.left = Object.new TreeNode(4);
        root.left.right = Object.new TreeNode(5);

  
        TreeNode invertedRoot = Object.invertTree(root);

        
        System.out.println("Inverted Tree (Preorder Traversal):");
        Object.printTree(invertedRoot);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

      
        root.left = right;
        root.right = left;

        return root;
    }

    
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        
       
        printTree(root.left);
        
        
        printTree(root.right);
    }
}
