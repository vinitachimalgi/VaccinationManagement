

import java.util.Scanner;


public class Final {
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        int choice=0;
        boolean searchHospital;
        String HospitalName;
        do
        {
            System.out.println("Do you want to search a hospital?: ");
            searchHospital=sc.nextBoolean();
            if(searchHospital)
            {
                System.out.println("Enter the name of the hospital: ");
                HospitalName=sc.next();
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
                Node searched=Tree.search(Required,Tree.root);
                if(searched!=null)
                {
                    System.out.println("Available slots for "+searched.h.getName()+": "+searched.h.getSlotsLeft());
                    boolean bookSlot=false;
                    System.out.println("Do you want to book a slot?: ");
                    bookSlot=sc.nextBoolean();
                    PriorityQueue p=new PriorityQueue();
                    if(bookSlot)
                    {
                        p.MenuDriven();
                    }
                }
                else
                {
                    System.out.println("Hospital doesn't exist in the list");
                }
            }

        }while(searchHospital==false);
		/*
		do
		{
			do
			{
				System.out.println("Searching up hospitals in the available list");
				System.out.println("Booking a vaccination slot in a hospital");
				System.out.println("Enter your choice: ");
				choice=sc.nextInt();
			}while(choice<1||choice>2);
			switch(choice)
			{
			case 1:

			}
		}
		*/
    }

}
