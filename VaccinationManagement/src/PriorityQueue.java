import java.util.Scanner;

public class PriorityQueue {
	public static void main(String [] args)
	{
		int[] arr=new int[50];
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("Enter the number of entries");
		n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the number: ");
			arr[i]=sc.nextInt();
		}
		Heap h=new Heap(arr,n);
		h.print();
		for(int i=n/2;i>=0;i--)
		{
			h.shiftDown(i);
		}
		h.print();
		h.insert(34);
		h.print();
		h.delete();
		h.print();
	}

}
