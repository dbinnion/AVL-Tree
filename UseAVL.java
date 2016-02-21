package testpackage;

public class UseAVL 
{
	private static Node root;
	
    public static void main(String[] args) 
    {
        AVLTree tree = new AVLTree();
        
        for(int i=0;i<100;i++)
        {
        	int value=(int)(Math.random()*100)+1;
        	root = tree.insert(root, value);
        }
 
        System.out.println("Inorder : ");
        tree.inOrder(root);
        System.out.println();
        
        System.out.println(root.getHeight());
    }
}
