import java.util.ArrayList;
import java.util.Collections;

public class Heap {
	//private User[] H=new User[100];
	private ArrayList<User> Users=new ArrayList<User>();
	
	public Heap(ArrayList<User> U) {
		super();
		Users=U;
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
    	while(i>0&&(Users.get(parent(i)).getAge()<Users.get(i).getAge()))
    		{
    		/*
    		  User temp=H[i];
    		  H[i]=H[parent(i)];
    		  H[parent(i)]=temp;
    		  i=parent(i);
    		  */
    		Collections.swap(Users,i,parent(i));
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
        if((l<Users.size())&&Users.get(max).getAge()<Users.get(l).getAge())
        {
        	max=l;
        }
        if((r<Users.size())&&(Users.get(max).getAge()<Users.get(r).getAge()))
        {
        	max=r;
        }
    	if(i!=max)
    	{
    		Collections.swap(Users,i,max);
    		shiftDown(max);
    	}

    }
    public void insert(User key)
    {
    	//H[size-1]=key;
    	Users.add(key);
    	for(int i=0;i<=Users.size()/2;i++)
    	{
			shiftUp(Users.size()-1);
    	}
    }
    public User delete()
    {
    	
    	User max=Users.get(0);
    	Users.set(0, Users.get(Users.size()-1));
    	Users.remove(Users.size()-1);
    	for(int i=Users.size()/2;i>=0;i--)
    	{
			shiftDown(i);
    	}
    	return max;
    }
    public void print()
    {
    	for(int i=0;i<Users.size();i++)
    	{
    		System.out.print(Users.get(i).toString()+ " ");
    	}
    	System.out.println();
    }
}
