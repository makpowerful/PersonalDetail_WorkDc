package RS_DS_Alogrithms;


public class BinarySearchTrees {

	
	private class Node {
		
		int value;
		Node left;
		Node right;
	
	public Node(int value)
	{
		this.value =value;
	}
}
	Node root;
	
	public void insert(int value)
	{
		root = insertNode(root, value);
	}
	
	public Node insertNode(Node root, int value)
	{
		
		if ( root == null)
		{
		root = new Node(value);
		return root;
		}
		
		if( value < root.value)
			root.left = insertNode(root.left,value);
		else if (value > root.value)
			root.right = insertNode(root.right, value);
		
		return root;
		
	}
	
	public Boolean valueSearch(int value)
	{
		return search (root,value);
	}
	
	public boolean search(Node root, int value)
	{
		
		if (root == null)
			return false;
		if(value == root.value)
			return true;
		
		if (value< root.value)
		return search(root.left,value);
		
		else
			return search(root.right,value);
		
	}
	
	  public int getMinElement()
	    {
	    	return minElement(root);
	    }
	    
	    public int minElement(Node root)
	    {
	    	Node current;
	    	current = root;
	  
	    	
	    	while (current.left != null) 
	    	{
	    		current = current.left;
	    	
	    	}
	    	return current.value;
	   
	    	}
	    
	    public int getHeight()
	    {
	    	return height(root);
	    }
	    public int height(Node root)
	    {
	    	if(root == null)
	    		return -1;
	    	
	    	return 1 + Math.max(height(root.left),height(root.right));
	    }
	    
	    public int getMaxElement()
	    {
	    	return maxElement(root);
	    } 
	    
	    public int maxElement(Node root)
	    {
	    	Node current;
	    	current = root;
	  
	    	
	    	while (current.right != null) 
	    	{
	    		current = current.right;
	    	
	    	}
	    	return current.value;
	   
	    	}
	    
	public void SortedOrder()
	{
		inorderTraverse(root);
	}
	
	public void inorderTraverse(Node root)
	{
		if(root!= null)
		{
			inorderTraverse(root.left);
			System.out.println(root.value);
			inorderTraverse(root.right);
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTrees tree = new BinarySearchTrees();
			tree.insert(4);
		 	tree.insert(6);
	        tree.insert(12);
	        tree.insert(3);
	        tree.insert(1);
	        tree.insert(7);
	        tree.insert(14);
	        tree.insert(17);
	        tree.insert(2);
	        tree.SortedOrder();
	        //sort logic In order traversal
	        System.out.println("Minimum element is "+tree.getMinElement());
	        System.out.println("Maximum element is "+tree.getMaxElement());
	        System.out.println("Height of tree is "+tree.getHeight());
	        System.out.println(tree.valueSearch(14)); //O(logn)
	        System.out.println(tree.valueSearch(55));
	        
	        
	        
	        
	}

}
