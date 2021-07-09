
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
    		  swap(H[i],H[parent(i)]);
    		  i=parent(i);
    		}
    }
    public void shiftDown(int i)
    {
    	int max=i;
    	int l=leftchild(i);
    	if(H[max]<H[l])
    	{
    		max=l;
    	}
    	int r=rightchild(i);
    	if(H[max]<H[r])
    	{
    		max=r;
    	}
    	if(i!=max)
    	{
    		swap(H[i],H[max]);
    		shiftDown(max);
    	}
    }
    public void insert(int key)
    {
    	size=size+1;
    	H[size]=key;
    	
    	shiftUp(size);
    }
    public int delete()
    {
    	int max=H[0];
    	H[0]=H[size];
    	size=size-1;
    	shiftDown(0);
    	return max;
    }
    public int returnMax()
    {
    	return H[0];
    }
    static void swap(int x,int y)
    {
    	int temp;
    	temp=x;
    	x=y;
    	y=temp;
    }
}
