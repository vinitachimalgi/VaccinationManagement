import java.util.ArrayList;
import java.util.Scanner;

public class PriorityQueue {

	public static void main(String[] args) {
		ArrayList<User> Users = new ArrayList<User>();
		Scanner sc = new Scanner(System.in);
		int n, age;
		int length;
		User max;
		long aadharno;
		String name;
		final String Validator = "[A-Z]*";
		int choice = 0;
		Heap h=new Heap(Users);
		do {
			choice = menu();
			switch (choice) {
			case 1:  //multiple entries
				System.out.println("Enter the number of entries");
				n = sc.nextInt();

				for (int i = 0; i < n; i++) {
					do {
						System.out.println("Enter name*Capital letters only*: ");
						name = sc.next();
						if(name.matches(Validator) == false)
						{
							System.out.println("\nEnter valid name");
						}
						
					}while(name.matches(Validator) == false);
					
					do {
						System.out.println("Enter aadhar card number: ");
						aadharno = sc.nextLong();
						length = (int) (Math.log10(aadharno) + 1);
						if(length != 12)
						{
							System.out.println("\nEnter valid aadhar number");
						}
					}while(length != 12);
					
					System.out.println("Enter the age");  //enter an exception for less tan 18
					age = sc.nextInt();
					Users.add(new User(name, aadharno, age));
				}
				h.print();
				for (int i = n / 2; i >= 0; i--) {
					h.shiftDown(i);
				}
				System.out.println("The above people have been enrolled for vaccination");
				break;
				
				
			case 2:  //insert one new entry
				System.out.println("Enter the data: ");
				
				do
				{
					System.out.println("Enter name: ");
					name = sc.next();
					if(!name.matches(Validator))
					{
						System.out.println("\nPlease enter a valid name");
					}
					
				}while(!name.matches(Validator));
				
				do
				{
					System.out.println("Enter aadhar card number: ");
					aadharno = sc.nextLong();
					length = (int)(Math.log10(aadharno)+1);
					if(length != 12)
					{
						System.out.println("\nEnter a valid aadhar number");
					}
				}while(length != 12);
				
				System.out.println("Enter the age");
				age = sc.nextInt();
				User u=new User(name,aadharno,age);
				h.insert(u);
				System.out.println("The above citizen has been enrolled for vaccination");
                break;
                
                
			case 3:  //deletion
				
				max = h.delete();
				if(max == null)
				{
					System.out.println("\n No more people left!!!\n");
				}
				else
				{
					System.out.println(max.toString()+"- Vaccinated");
				}
				break;
				
				
			case 4:  //printing the entries
				if(Users.size() == 0)
				{
					System.out.println("\nThe list is empty\n");
					
				}
				else
				{
					System.out.println("The order of patients to be vaccinated is as follows: ");
					h.print();
				}
				
				break;
				
			case 0:
				System.out.println("No Vaccination will be proceeded further");
				break;
				
			
			}
			
			
		} while (choice != 0);

		/*
		 * arr[0] = new User("rutu",1,19); arr[1] = new User("anu",2,17); arr[2] = new
		 * User("vini",3,34); arr[3] = new User("nive",4,23); arr[4] = new
		 * User("manju",1,50);
		 */
		// System.out.println("After deletion : ");
		sc.close();

	}
	public static int menu()
	{
		int choice = 0;
		Scanner sc= new Scanner(System.in);
		do
		{
			System.out.println("**M E N U**");
			System.out.println("1.Enter multiple entries");
			System.out.println("2.Enter single entry");
			System.out.println("3.Get vaccinated");
			System.out.println("4.Display list");
			System.out.println("0.Exit");
			System.out.println("Enter your choice: ");
			choice=sc.nextInt();
		}while(choice<0 || choice>4);
		return choice;
	}
}
