package Trees;

public class LeetCode112pathsum {

	public static void main(String[] args) {
		LeetCode112pathsum Object = new LeetCode112pathsum();
        
      
        TreeNode root = Object.new TreeNode(5);
        root.left = Object.new TreeNode(4);
        root.right = Object.new TreeNode(8);
        root.left.left = Object.new TreeNode(11);
        root.right.left = Object.new TreeNode(13);
        root.right.right = Object.new TreeNode(4);
        root.left.left.left = Object.new TreeNode(7);
        root.left.left.right = Object.new TreeNode(2);
        root.right.right.right = Object.new TreeNode(1);

        int targetsum = 22;

      
        boolean result = Object.hasPathSum(root, targetsum);
        System.out.println("Has path sum " + targetsum + ": " + result);
		

	}
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		 }
	}
     
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		
		if(root.val == targetSum && root.left == null && root.right == null) {
			return true;
		}
		
		return hasPathSum(root.left , targetSum-root.val) || hasPathSum(root.right , targetSum-root.val);
		
		
    }

}
