package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class leetCode116 {

	public static void main(String[] args) {
		leetCode116 Object = new leetCode116();
		
		Node root = Object.new Node(1);
		root.left = Object.new Node(2);
		root.right = Object.new Node(3);
		root.left.left = Object.new Node(4);
		root.left.right = Object.new Node(5);
		root.right.left = Object.new Node(6);
		root.right.right = Object.new Node(7);
		
		
		
		Object.connect(root);
		System.out.println(Object.getLevelOrderWithNextPointers(root)); 
	}
	public class Node{
		int val;
		Node left;
		Node right;
		Node next;
		
		public Node(int val) {
			this.val=val;
		}
		
		public Node(int val, Node left, Node right, Node next) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.next = next;
		}
	}
    public Node connect(Node root) {
       if(root == null) {
    	   return null;
       }
       
       Node leftmost = root;
       while(leftmost.left != null) {
    	   Node current = leftmost;
    	   while(current != null) {
    		   current.left.next = current.right;
    		   if(current.next != null) {
    			   current.right.next = current.next.left;
    		   }
    		   current = current.next;
    	   }
    	   leftmost = leftmost.left;
       }
       return root;
    }
    
    public String getLevelOrderWithNextPointers(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();  
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                result.append(current.val).append(",");
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.append("#,");  
        }

    
        return result.substring(0, result.length() - 1);
    }
 }
