package Trees;

import java.util.Arrays;

public class LeetCode105 {

	public static void main(String[] args) {
		LeetCode105 Object = new LeetCode105();
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		TreeNode root = Object.buildTree(preorder, inorder);
		System.out.println("Tree constructed successfully.");
		
		
		

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
	
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	
    	if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int r = preorder[0];
        int index = 0;
        
        for(int i=0; i<inorder.length;i++) {
        	if(inorder[i] == r) {
        		index = i;
        	}
        }
        
        TreeNode node = new TreeNode(r);
        
        node.left = buildTree(Arrays.copyOfRange(preorder , 1 , index+1) , Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder , index+1 , preorder.length) , Arrays.copyOfRange(inorder, index+1, inorder.length));
        
        return node;
    }

}
