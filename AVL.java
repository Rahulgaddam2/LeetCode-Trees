package Trees;

public class AVL {

    public static void main(String[] args) {
        AVL avltree = new AVL();
        
        int[] nums = {7,6,4,6,7,8,3,4,6,2,3,1};
        
        avltree.push(nums);
        avltree.display();
    }

    public static class Node {
        int value;
        Node left;
        Node right;
        int height;

        public Node(int value) {
            this.value = value;
            this.height = 0;         // height of a new node is 0
        }
    }

    private Node root;

    // Get the height of the node
    public int height(Node node) {
        if (node == null) {
            return -1; // return -1 if null for height calculation
        }
        return node.height;
    }

    // Inserting a value into the AVL tree
    public void insert(int value) {
        root = insert(value, root);
    }

    // Recursive insertion
    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value); // create a new node
        }

        // Standard BST insert
        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value > node.value) {
            node.right = insert(value, node.right);
        } else {
            return node; // Duplicate values are not inserted
        }

        // Update height of the current node
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Get balance factor to check whether the node is unbalanced
        int balanceFactor = getBalance(node);

        // Left heavy
        if (balanceFactor > 1) {
            if (value < node.left.value) {
                // Left-Left case
                return rotateRight(node);
            } else {
                // Left-Right case
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        // Right heavy
        if (balanceFactor < -1) {
            if (value > node.right.value) {
                // Right-Right case
                return rotateLeft(node);
            } else {
                // Right-Left case
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node; // Return the node reference
    }

    // Right rotate
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // New root
    }

    // Left rotate
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // New root
    }

    // Get balance factor of node
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Push an array of values into the AVL tree
    public void push(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    // Display the tree
    public void display() {
        display(this.root, "Root node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value + " (Height: " + node.height + ")");
        display(node.left, "Left child of " + node.value + ": ");
        display(node.right, "Right child of " + node.value + ": ");
    }
}
