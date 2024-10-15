package Trees;



public class LeetCode98preorder {

	public static void main(String[] args) {
		
		LeetCode98preorder Object = new LeetCode98preorder();
 		
		TreeNode root = Object.new TreeNode(5);
		root.left = Object.new TreeNode(1);
		root.right = Object.new TreeNode(4);
		root.right.left = Object.new TreeNode(3);
		root.right.right = Object.new TreeNode(6);
		
		System.out.println(Object.isValidBST(root));
		
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
	
	public boolean isValidBST(TreeNode root) {
		return helper(root, null , null);
	}
	public Boolean helper(TreeNode node ,  Integer low , Integer high) {
		if(node == null) {
			return true;
		}
		
		if(low != null && node.val <= low) {
			return false;
		}
		
		if(high != null && node.val >= high ) {
			return false;
		}
		
		Boolean lefttree = helper(node.left , low , node.val);
		Boolean righttree = helper(node.right , node.val , high);
		
		return lefttree && righttree;
			
	}

}
