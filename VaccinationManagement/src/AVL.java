import java.util.Scanner;

public class AVL {
	protected Node root;
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
	public Node insert(Node node,Hospital h)
	{
		if(node==null)
		{
			return (new Node(h));
		}
		if(h.getName().compareTo(node.h.getName())>0)
		{
			node.right=insert(node.right, h);
		}
		else if(h.getName().compareTo(node.h.getName())<0)
		{
			node.left=insert(node.left, h);
		}
		else
		{
			return node;
		}
		node.height=1+max(getHeight(node.left),getHeight(node.right));
		int balanceFactor=getBalancefactor(node);
		if(balanceFactor>1)
		{
			if(h.getName().compareTo(node.left.h.getName())<0)
			{
				return rightRotate(node);
			}
			else if(h.getName().compareTo(node.h.getName())>0)
			{
				node.left=leftRotate(node.left);
				return rightRotate(node);
			}
		}
		if(balanceFactor<-1)
		{
			if(h.getName().compareTo(node.h.getName())>0)
			{
				return leftRotate(node);
			}
			else if(h.getName().compareTo(node.h.getName())<0)
			{
				node.right=rightRotate(node.right);
				return leftRotate(node);
			}
		}
		return node;
	}
	public Node search(Hospital h, Node root) {
		Node froot = root;
		if(froot!=null)
		{
			if(h.getName().compareTo(froot.h.getName())>0)
			{
				froot=search(h,froot.right);
			}
			else if(h.getName().compareTo(froot.h.getName())<0)
			{
				froot=search(h,froot.left);
			}
			else if(h.getName().compareTo(froot.h.getName())==0)
			{
				//System.out.println("\nEqual mila"+froot.h.getName());
				return froot;
			}
		}
		//System.out.println("\nSabse bahar"+froot.h.getName());
		return froot;
	}
	public void printPreorder(Node root)
	{
		if(root!=null)
		{
			System.out.println(root.h.getName());
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}
	public void printInorder(Node root)
	{
		if(root!=null)
		{
			printInorder(root.left);
			System.out.println(root.h.getName());
			printInorder(root.right);
		}
	}
	/*
	public class Node
	{
		private Node left;
		private Node right;
		private Hospital h;
		private int height;

		Node(Hospital h)
		{
			this.h=h;
			height=1;
		}
	}
	*/
	public static void main(String [] args)
	{
		/*
		Hospital[] hospitals=new Hospital[10];
		hospitals[0]=new Hospital("Apollo Jubliee");
		hospitals[1]=new Hospital("Apollo Jubliee");
		hospitals[2]=new Hospital("Rainbow");
		hospitals[3]=new Hospital("Appollo Hitech");
		hospitals[4]=new Hospital("KIMS");
		hospitals[5]=new Hospital("Deenanaat");
		hospitals[6]=new Hospital("Sasun");
		hospitals[7]=new Hospital("Ruby");
		hospitals[8]=new Hospital("Jahangir");
		hospitals[9]=new Hospital("Sancheti");
		AVL Tree=new AVL();
		for(int i=0;i<hospitals.length;i++)
		{
			Tree.root=Tree.insert(Tree.root, hospitals[i]);
		}
		Tree.printPreorder(Tree.root);
		Hospital Required=new Hospital(HospitalName);
		Node searched=search(Required,Tree.root);
		if(searched!=null)
		{
			System.out.println("Available slots for "+searched.h.getName()+": "+searched.h.getSlotsLeft());
		}
		else
		{
			System.out.println("Hospital doesn't exist in the list");
		}
	*/
	}
}
