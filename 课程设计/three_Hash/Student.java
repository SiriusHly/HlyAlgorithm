package three_Hash;
/**
 * 
 * @author hly
 * time:17.12.31
 * Ñ§ÉúÀà
 *
 */
class Student{
	private String name;
	private String classes;
	private String number;
	private String gender;
	private String telephone;
	private String address;
	public Student(String name, String classes, String number, String gender, String telephone, String address) {
		super();
		this.name = name;
		this.classes = classes;
		this.number = number;
		this.gender = gender;
		this.telephone = telephone;
		this.address = address;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getClasses() {
		return classes;
	}


	public void setClasses(String classes) {
		this.classes = classes;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", classes=" + classes + ", number=" + number + ", gender=" + gender
				+ ", telephone=" + telephone + ", address=" + address + "]";
	}
}