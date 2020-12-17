package mainpack.subpack.package1.vo;

public class Employee {
	private int empno;
	private int deptno;
	private String fname;
	private String mname;
	private String zipcode;
	private String cpnum;
	private boolean married;
	private String position;
	private int salevel;
	private int salary;
	
	//setters and getters
	public int getEmpno() {		return empno;	}
	public void setEmpno(int empno) {		this.empno = empno;	}
	public int getDeptno() {		return deptno;	}
	public void setDeptno(int deptno) {		this.deptno = deptno;	}
	public String getFname() {		return fname;	}
	public void setFname(String fname) {		this.fname = fname;	}
	public String getMname() {		return mname;	}
	public void setMname(String mname) {		this.mname = mname;	}
	public String getZipcode() {		return zipcode;	}
	public void setZipcode(String zipcode) {		this.zipcode = zipcode;	}
	public String getCpnum() {		return cpnum;	}
	public void setCpnum(String cpnum) {		this.cpnum = cpnum;	}
	public boolean isMarried() {		return married;	}
	public void setMarried(boolean married) {		this.married = married;	}
	public String getPosition() {		return position;	}
	public void setPosition(String position) {		this.position = position;	}
	public int getSalevel() {		return salevel;	}
	public void setSalevel(int salevel) {		this.salevel = salevel;	}
	public int getSalary() {		return salary;	}
	public int calcSalary(String position, int salevel) {
		int basal;
		switch (position) {
		case "leader":
			basal = 10000000;
			break;
		case "manager":
			basal = 5000000;
			break;
		case "member":
			basal = 2500000;
			break;
		default:
			basal = 2000000;
			break;
		}
		int finsal = basal + salevel*150000;
		return finsal; 
	}
	// setters and getters end
	// constructors
	public Employee(){};//initialize
	public Employee(int empno, int deptno, String fname, String mname) {//register new employee
		this.empno = empno;
		this.deptno = deptno;
		this.fname = fname;
		this.mname = mname;
	}
	public Employee(int empno, int deptno, String zipcode, String cpnum, boolean married,
			String position, int salevel, int salary) {//imported or loaded case
		super();
		this.empno = empno;
		this.deptno = deptno;
		this.zipcode = zipcode;
		this.cpnum = cpnum;
		this.married = married;
		this.position = position;
		this.salevel = salevel;
		this.salary = salary;
	}
	// constructors end
	public String promotion() {
		String result = "there's a problem unidentified yet";
		String temp = this.position;
		int checklv = this.salevel;
		if (checklv < 4) {//promotion is allowed to well-experienced workers
			result = "this employee needs more experience on his(her) current position.";
			return result;
		}
		switch (temp) {
		case "manager":
			this.position = "leader";
			this.salevel = 0;
			break;
		case "member":
			this.position = "manager";
			this.salevel = 0;
			break;
		}
		return result;
	}
	public String salup() {
		int temp = this.salevel;
		String result = "";
		if (this.salevel == 5) {
			result =  "the payment of this employee is already at the top";
			return result;
		}
		this.salevel = this.salevel +1;
		result = "salay up applied to "+this.fname+"; "+temp+"=>"+this.salevel;
		return result;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", deptno=" + deptno + ", fname=" + fname + ", mname=" + mname
				+ ", zipcode=" + zipcode + ", cpnum=" + cpnum + ", married=" + married + ", position=" + position
				+ ", salevel=" + salevel + ", salary=" + salary + "]";
	}
}
