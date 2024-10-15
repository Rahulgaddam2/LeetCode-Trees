package Trees;



public class LeetCode236Preorder {

	public static void main(String[] args) {
		
		LeetCode236Preorder Object = new LeetCode236Preorder();
		
		TreeNode root = Object.new TreeNode(5);
		root.left = Object.new TreeNode(1);
		root.right = Object.new TreeNode(4);
		root.right.left = Object.new TreeNode(3);
		root.right.right = Object.new TreeNode(6);
		
		
		TreeNode p = root.right.left;       
        TreeNode q = root.right.right;  
        
        System.out.println("LCA: " + Object.lowestCommonAncestor(root, p, q).val);
		
	}
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
		
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root == null) {
			return null;
		}
		
		if(root == p || root == q) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left , p ,q);
		TreeNode right = lowestCommonAncestor(root.right , p ,q);
		
		if(left!= null && right !=null) {
			return root;
		}
		
		return left == null ? right : left;
		
		
		
	}

}
