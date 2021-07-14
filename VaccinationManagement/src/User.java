
public class User {
	private String name;
	private long aadharno;
	private int age;
	
	
	public User(String name, long aadharno, int age) {
		super();
		this.name = name;
		this.aadharno = aadharno;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAadharno() {
		return aadharno;
	}
	public void setAadharno(long aadharno) {
		this.aadharno = aadharno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", aadharno=" + aadharno + ", age=" + age + "]\n";
	}

}
