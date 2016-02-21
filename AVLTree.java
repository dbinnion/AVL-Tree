package testpackage;

public class AVLTree 
{
	public AVLTree()
	{	}
	
    private int height(Node node) 
    {
        if (node == null)
        {
            return 0;
        }
        return node.getHeight();
    }
 
    private int max(int a, int b) 
    {
        return (a > b) ? a : b;
    }
 
    private Node rightRotate(Node y) 
    {	
        Node x = y.getLeft();
        Node temp = x.getRight();	//likely null
 
        x.setRight(y);	//the rotation
        y.setLeft(temp);	//set to null
		 
        int xheight = max(height(x.getLeft()), height(x.getRight())) + 1;
        int yheight = max(height(y.getLeft()), height(y.getRight())) + 1;
        
        x.setHeight(xheight);
        y.setHeight(yheight);
 
        //return the new root
        return x;
    }
 
    private Node leftRotate(Node x) 
    {	
		Node y = x.getRight();
		Node temp = y.getLeft();	//likely null
		  
		y.setLeft(x);	//the rotation
		x.setRight(temp);	//set to null
		
        int xheight = max(height(x.getLeft()), height(x.getRight())) + 1;
        int yheight = max(height(y.getLeft()), height(y.getRight())) + 1;
 
        x.setHeight(xheight);
        y.setHeight(yheight);
        
        //return the new root
        return y;
    }
 
    int getBalance(Node node) 
    {
        if (node == null) 
        {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }
 
    //returns the root node, sets new nodes
    public Node insert(Node node, int value) 
    {
        if (node == null) 
        {
            return (new Node(value));
        }
 
        if (value < node.getValue()) 
        {
        	node.setLeft(insert(node.getLeft(), value));
        } 
        else 
        {
        	node.setRight(insert(node.getRight(), value));
        }
 
        //assign height to node
        int nodeheight = max(height(node.getLeft()), height(node.getRight())) + 1;
        node.setHeight(nodeheight);
        
        int balance = getBalance(node);
 
        //rotate all left
        if (balance > 1 && value < node.getLeft().getValue()) {
            return rightRotate(node);
        }
 
        //rotate all right
        if (balance < -1 && value > node.getRight().getValue()) {
            return leftRotate(node);
        }
 
        //rotate left then right
        if (balance > 1 && value > node.getLeft().getValue()) {
        	node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
 
        //rotate right then left
        if (balance < -1 && value < node.getRight().getValue()) {
        	node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }
 
        return node;
    }
 
    //1+2
    public void inOrder(Node node) {
        if (node != null) {
        	inOrder(node.getLeft());
        	System.out.print(node.getValue() + " ");
            inOrder(node.getRight());
        }
    }
    
    //+12
    public void preOrder(Node node) {
        if (node != null) {
        	System.out.print(node.getValue() + " ");
        	preOrder(node.getLeft());
        	preOrder(node.getRight());
        }
    }
    
    //12+
    public void postOrder(Node node) {
        if (node != null) {
        	postOrder(node.getLeft());
        	postOrder(node.getRight());
        	System.out.print(node.getValue() + " ");
        }
    }

}