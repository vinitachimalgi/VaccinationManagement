import java.util.ArrayList;

public class Hospital {
	private String Name;
	private int slotsLeft;
	protected PriorityQueue priorityQueue;

	public Hospital(String name) {
		super();
		Name = name;
		this.slotsLeft = 10;
		ArrayList<User> list=new ArrayList<User>();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getSlotsLeft() {
		return slotsLeft;
	}

	public void setSlotsLeft(int slotsLeft) {
		this.slotsLeft = slotsLeft;
	}


}
