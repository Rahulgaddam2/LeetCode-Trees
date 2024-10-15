package Trees;

import java.util.*;

public class LeetCode103 {

	public static void main(String[] args) {
		LeetCode103 Object = new LeetCode103();
		
		TreeNode root = Object.new TreeNode(3);
		root.left = Object.new TreeNode(9);
		root.right = Object.new TreeNode(20);
		root.right.left = Object.new TreeNode(15);
		root.right.right = Object.new TreeNode(7);
		
		List<List<Integer>> Final = new ArrayList<>(Object.zigzagLevelOrder(root));
		
		System.out.println(Final);

	}
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val=val;
		}
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val=val;
			this.left=left;
			this.right=right;
		}
	}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) {
        	return result;
        }
        
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while(!queue.isEmpty()) {
        	int levelsize = queue.size();
        	List<Integer> currentlevel = new ArrayList<>(levelsize);
        	for(int i=0;i<levelsize;i++) {
        		
        		if(!reverse) {
        			TreeNode currentNode = queue.pollFirst();
            		currentlevel.add(currentNode.val);
            		if(currentNode.left != null) {
            			queue.offerLast(currentNode.left);
            		}
            		if(currentNode.right != null) {
            			queue.offerLast(currentNode.right);
            		}
        		}else {
        			TreeNode currentNode = queue.pollLast();
            		currentlevel.add(currentNode.val);
            		if(currentNode.right != null) {
            			queue.offerFirst(currentNode.right);
            		}
            		if(currentNode.left != null) {
            			queue.offerFirst(currentNode.left);
            		}
        		}
        		
        		reverse = !reverse;
        		
        	}
        	result.add(currentlevel);
        	
        }
        return result;
    }
}
