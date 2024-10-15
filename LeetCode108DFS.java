package Trees;

public class LeetCode108DFS {

	public static void main(String[] args) {
		LeetCode108DFS object = new LeetCode108DFS();

        int[] nums = {-10,-3, 0, 5, 9};
        TreeNode root = object.sortedArrayToBST(nums);

        
        object.printTree(root);

	}
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val=val;
		}
		public TreeNode(int val , TreeNode left ,  TreeNode right) {
			this.val = val;
			this.left = left;
			this.right =right;
		}
	}
	public TreeNode sortedArrayToBST(int[] nums) {
		return BST(nums , 0 , nums.length-1);
	}
	public TreeNode BST(int[] nums , int left , int right) {
		
		if(left > right) {
			return null;
		}
		
		int mid = left + (right - left)/2;
		
		TreeNode node = new TreeNode(nums[mid]);
		
		node.left = BST(nums, left , mid-1);
		node.right = BST(nums, mid+1,right);
		return node;
	}
	public void printTree(TreeNode node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.val + " ");
            printTree(node.right);
        }
    }

}
