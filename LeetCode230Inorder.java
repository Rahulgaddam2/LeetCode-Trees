package Trees;



public class LeetCode230Inorder {

	public static void main(String[] args) {
		
		LeetCode230Inorder Object = new LeetCode230Inorder();
		
		TreeNode root = Object.new TreeNode(6);
        root.left = Object.new TreeNode(2);
        root.right = Object.new TreeNode(8);
        root.left.left = Object.new TreeNode(0);
        root.right.right = Object.new TreeNode(4);
        
        System.out.print(Object.kthSmallest(root, 4));
		

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
	
	int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root , k).val;
    }
    
    public TreeNode helper(TreeNode root , int k) {
    	if(root == null) {
    		return null;
    	}
    	
    	TreeNode left = helper(root.left,k);
    	
    	if(left != null) {
    		return left;
    	}
    	count ++;
    	
    	if(count == k) {
    		return root;
    	}
    	
    	return helper(root.right,k);
    }

}
