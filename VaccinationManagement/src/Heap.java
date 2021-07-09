
public class Heap {
	private int[] H=new int[100];
	private int size=-1;
	
	public Heap(int[] h, int size) {
		super();
		H = h;
		this.size = size;
	}
	
	static int parent(int i)
	{
		return (i-1)/2;
	}
	static int leftchild(int i)
	{
		return (2*i+1);
	}
    static int rightchild(int i)
    {
    	return (2*i+2);
    }
    public void shiftUp(int i)
    {
    	while(i>0&&(H[parent(i)]<H[i]))
    		{
    		  int temp=H[i];
    		  H[i]=H[parent(i)];
    		  H[parent(i)]=temp;
    		  i=parent(i);
    		}
    }
    public void shiftDown(int i)
    {
    	int max=i;
    	int l=leftchild(i);
    	int r=rightchild(i);
    	/*
    	int currentMax= (H[l]<H[r]) ? r : l;
    	if(H[max]<currentMax)
    	{
    		max=currentMax;
    	}
    	*/
    	if(H[max]<H[l]&&(l<size))
    	{
    		max=l;
    	}
    	if(H[max]<H[r]&&(r<size))
    	{
    		max=r;
    	}
    	if(i!=max)
    	{
    		int temp=0;
    		temp=H[max];
    		H[max]=H[i];
    		H[i]=temp;
    		shiftDown(max);
    	}
    }
    public void insert(int key)
    {
    	size=size+1;
    	H[size-1]=key;
    	for(int i=0;i<=size/2;i++)
    	{
			shiftUp(size-1);
    	}
    }
    public int delete()
    {
    	int max=H[0];
    	H[0]=H[size-1];
    	size=size-1;
    	for(int i=size/2;i>=0;i--)
    	{
			shiftDown(i);
    	}
    	return max;
    }
    public void print()
    {
    	for(int i=0;i<size;i++)
    	{
    		System.out.print(H[i]+ " ");
    	}
    	System.out.println();
    }
    static void swap(int x,int y)
    {
    	int temp;
    	temp=x;
    	x=y;
    	y=temp;
    }
}
