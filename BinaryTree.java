import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

import nodes.BinaryTreeNode;

public class BinaryTree {

    private int size;
    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode node) {
        root = node;
        size = 1;
    }

    public void insert(BinaryTreeNode node) {
        BinaryTreeNode current = root;

        while (true) {
            if (node.value > current.value) {
                if (current.right == null) {
                    current.right = node;
                    size++;
                    return;
                }
                else {
                    current = current.right;
                }
            }

            else if (node.value < current.value) {
                if (current.left == null) {
                    current.left = node;
                    size++;
                    return;
                }
                else {
                    current = current.left;
                }
            }

            else {
                System.out.println("Node is already in the tree.");
                return;
            }
        }
    }
    
    public int getMin() {
    	BinaryTreeNode current = root;
    	
    	while (true) {
    		if (current.left != null) {
    			current = current.left;
    		}
    		else {
    			return current.value;
    		}
    	}
    }
    
    public int getMax() {
    	BinaryTreeNode current = root;
    	
    	while (true) {
    		if (current.right != null)  {
    			current = current.right;
    		}
    		else {
    			return current.value;
    		}
    	}
    }

    public int size() {
        return size;
    }
    
    public BinaryTreeNode getRoot() {
    	return root;
    }

    public boolean contains(int value) {
        BinaryTreeNode current = root;

        while (true) {
            if (value > current.value) {
                if (current.right != null) {
                    current = current.right;
                }
                else {
                    return false;
                }
            }
            else if (value < current.value) {
                if (current.left != null) {
                    current = current.left;
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            }
        }
    }
    
    public void preOrder(BinaryTreeNode root) {
    	if (root == null) {
    		return;
    	}
    	
    	System.out.println(root.value);
    	preOrder(root.left);
    	preOrder(root.right);
    }
    
    public void inOrder(BinaryTreeNode root) {
    	if (root == null) {
    		return;
    	}
    	
    	inOrder(root.left);
    	System.out.println(root.value);
    	inOrder(root.right);
    }
    
    public void postOrder(BinaryTreeNode root) {
    	if (root == null) {
    		return;
    	}
    	
    	postOrder(root.left);
    	postOrder(root.right);
    	System.out.println(root.value);
    }
    
    public int getHeight(BinaryTreeNode node) {     	
    	if (node == null) {
    		return -1;
    	}
    	else {
    		return 1 + max(getHeight(node.right), getHeight(node.left));
    	}
    }
    
    private int max(int a, int b) {
    	if (a > b) {
    		return a;
    	}
    	else {
    		return b;
    	}
    }

    public void print() {
        Queue<BinaryTreeNode> nodes = new LinkedList<BinaryTreeNode>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            BinaryTreeNode current = nodes.remove();
            System.out.print(current.value + " ");
            
            if (current.left != null)   nodes.add(current.left);
            if (current.right != null)  nodes.add(current.right);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        BinaryTreeNode test = new BinaryTreeNode(50);
        BinaryTree tree = new BinaryTree(test);

        // insert 10 random nodes
        for (int i = 0; i < 10; i++) {
        	int randomInt = rand.nextInt(100);
        	System.out.println("Random num " + i + " " + randomInt);
        	
            BinaryTreeNode testing = new BinaryTreeNode(randomInt);
            tree.insert(testing);
        }

        // print tree, along with size, height, max and min
        System.out.println("Printed tree: ");
        tree.print();
        System.out.println("\nSize: " + tree.size() + " Height: " + tree.getHeight(tree.getRoot()) + " Max: " + tree.getMax() + " Min: " + tree.getMin());
        
        // preorder, inorder, and postorder traversals
        System.out.println("Preorder");
        tree.preOrder(tree.getRoot());
        
        System.out.println("Inorder");
        tree.inOrder(tree.getRoot());
        
        System.out.println("Postorder");
        tree.postOrder(tree.getRoot());
        
        System.out.println("Contains 50? " + tree.contains(50));
        System.out.println("Contains 24? " + tree.contains(24));
    }
}