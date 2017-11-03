package LIst;

public class Department {
	private String  departmentID;
	private String departmentName;

	public Department() {
	}
	

	public Department(String departmentID, String departmentName) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}


	public String getDepartmentID() {
		return departmentID;
	}


	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

    public String toString(){
    	return departmentID+" "+departmentName;
    }
	public static void main(String[] args) {

	}

}
