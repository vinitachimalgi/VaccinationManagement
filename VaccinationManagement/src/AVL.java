
public class AVL {
	private Node root;
	//not working
	public int getHeight(Node n)
	{
		if(n==null)
		{
			return 0;
		}
		return n.height;
	}
	public int max(int a,int b)
	{
		return (a>b ? a :b);
	}
	public int getBalancefactor(Node n)
	{
		if(n==null)
		{
			return 0;
		}
		return (getHeight(n.left)-getHeight(n.right));
	}
	public Node leftRotate(Node about)
	{
		Node y=about.right;
		Node temp=y.left;
		y.left=about;
		about.right=temp;
		about.height=max(getHeight(about.left),getHeight(about.right))+1;
		y.height=max(getHeight(y.left),getHeight(y.right))+1;
		return y;
	}
	public Node rightRotate(Node about)
	{
		Node x=about.left;
		Node temp=x.right;
		x.right=about;
		about.left=temp;
		about.height=max(getHeight(about.left),getHeight(about.right))+1;
		x.height=max(getHeight(x.left),getHeight(x.right))+1;
		return x;
	}
	public boolean greater(String a,String b)
	{
		if(a.compareTo(b)==-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public Node insert(Node node,String item)
	{
		if(node==null)
		{
			return (new Node(item));
		}
		if(item.compareTo(node.data)>0)
		{
			node.right=insert(node.right, item);
		}
		else if(item.compareTo(node.data)<0)
		{
			node.left=insert(node.left, item);
		}
		else
		{
			return node;
		}
		node.height=1+max(getHeight(node.left),getHeight(node.right));
		int balanceFactor=getBalancefactor(node);
		if(balanceFactor>1)
		{
			if(item.compareTo(node.left.data)<0)
			{
				return rightRotate(node);
			}
			else if(item.compareTo(node.data)>0)
			{
				node.left=leftRotate(node.left);
				return rightRotate(node);
			}
		}
		if(balanceFactor<-1)
		{
			if(item.compareTo(node.data)>0)
			{
				return leftRotate(node);
			}
			else if(item.compareTo(node.data)<0)
			{
				node.right=rightRotate(node.right);
				return leftRotate(node);
			}
		}
		return node;
	}
	public void printPreorder(Node root)
	{
		if(root!=null)
		{
			System.out.println(root.data);
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}
	public void printInorder(Node root)
	{
		if(root!=null)
		{
			printInorder(root.left);
			System.out.println(root.data);
			printInorder(root.right);
		}
	}
	public class Node
	{
		private Node left;
		private Node right;
		private String data;
		private int height;
		
		Node(String data)
		{
			this.data=data;
			height=1;
		}
	}
	public static void main(String [] args)
	{
		String[] names=new String[10];
		names[0]="Appollo Jubliee";
		names[1]="LV Prasad";
		names[2]="Rainbow";
		names[3]="Appollo Hitech";
		names[4]="KIMS";
		names[5]="Deenanaat";
		names[6]="Sasun";
		names[7]="Ruby";
		names[8]="Jahangir";
		names[9]="Sancheti";
		int[] numbers=new int[6];
		numbers[0]=6;
		numbers[1]=5;
		numbers[2]=3;
		numbers[3]=8;
		numbers[4]=1;
		numbers[5]=2;
		AVL Tree=new AVL();
		for(int i=0;i<names.length;i++)
		{
			Tree.root=Tree.insert(Tree.root, names[i]);
		}
		Tree.printPreorder(Tree.root);
	}

}
