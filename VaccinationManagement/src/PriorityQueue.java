import java.util.ArrayList;
import java.util.Scanner;

public class PriorityQueue {

	public static void main(String[] args) {
		ArrayList<User> Users = new ArrayList<User>();
		Scanner sc = new Scanner(System.in);
		int n, age;
		long aadharno;
		String name;
		int choice = 0;
		Heap h=new Heap(Users);
		do {
			choice = menu();
			switch (choice) {
			case 1:
				System.out.println("Enter the number of entries");
				n = sc.nextInt();

				for (int i = 0; i < n; i++) {
					System.out.println("Enter name: ");
					name = sc.next();
					System.out.println("Enter aadhar card number: ");
					aadharno = sc.nextLong();
					System.out.println("Enter the age");
					age = sc.nextInt();
					Users.add(new User(name, aadharno, age));
				}
				h.print();
				for (int i = n / 2; i >= 0; i--) {
					h.shiftDown(i);
				}
				System.out.println("The above people have been enrolled for vaccination");
				break;
			case 2:
				System.out.println("Enter the data: ");
				System.out.println("Enter name: ");
				name = sc.next();
				System.out.println("Enter aadhar card number: ");
				aadharno = sc.nextLong();
				System.out.println("Enter the age");
				age = sc.nextInt();
				User u=new User(name,aadharno,age);
				h.insert(u);
				System.out.println("The above citizen has been enrolled for vaccination");
                break;
			case 3:
				System.out.println(Users.get(0).toString()+"- Vaccinated");
				h.delete();
				break;
			case 4:
				System.out.println("The order of patients to be vaccinated is as follows: ");
				h.print();
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
