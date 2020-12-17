package mainpack.subpack.package1.dao;

import java.util.*;
import mainpack.subpack.package1.vo.Employee;

public interface EmployeeMapper {
	public List<Employee> getAll();
	public List<Employee> getAllindiv();
	public int fired(int empnum);
	public int insert(Employee emp);
	public int inputdetails(Employee emp);
	public int promotion(int empnum);
	public int salup(int empnum);
	public int update(Employee emp);
	public int updateindiv(Employee emp);
}
