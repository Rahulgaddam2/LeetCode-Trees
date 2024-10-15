package Trees;

public class LeetCode235Preorder {

	public static void main(String[] args) {
		
		LeetCode235Preorder Object = new LeetCode235Preorder();
        
        TreeNode root = Object.new TreeNode(6);
        root.left = Object.new TreeNode(2);
        root.right = Object.new TreeNode(8);
        root.left.left = Object.new TreeNode(0);
        root.right.right = Object.new TreeNode(4);
        
        TreeNode p = root.left;  // Node with value 1
        TreeNode q = root.right; // Node with value 8
        
        System.out.println("LCA: " + Object.lowestCommonAncestorofbinarytree(root, p, q).val);

	}
	
	public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int x) {
            this.val = x;
        }
    }
	
	 public TreeNode lowestCommonAncestorofbinarytree(TreeNode root, TreeNode p, TreeNode q) {
		 if (root == null) {
	            return null;
	        }
	       
	       if(p.val < root.val && q.val < root.val){
	          return lowestCommonAncestorofbinarytree(root.left,p,q);
	       }

	       if(p.val > root.val && q.val > root.val){
	          return lowestCommonAncestorofbinarytree(root.right,p,q);
	       }

	       return root;

	    }
	 }

