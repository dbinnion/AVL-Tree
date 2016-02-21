package testpackage;

public class Node {
 
    int value;
    private int height;
    private Node left;
    private Node right;
 
    public Node()
    {
    	
    }
    
    public Node(int d) {
        value = d;
        height = 1;
    }
    
    public int getValue()
    {
    	return value;
    }
    
    public int getHeight()
    {
    	return height;
    }

    public Node getLeft()
    {
    	return left;
    }
    
    public Node getRight()
    {
    	return right;
    }
    
    public void setHeight(int input)
    {
    	height = input;
    }

    public void setLeft(Node input)
    {
    	left = input;
    }
    
    public void setRight(Node input)
    {
    	right = input;
    }
}