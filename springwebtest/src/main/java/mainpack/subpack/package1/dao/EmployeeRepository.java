package mainpack.subpack.package1.dao;

import java.util.*;

import mainpack.subpack.package1.vo.Employee;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class EmployeeRepository {
	@Autowired
	SqlSession session;
	
	public List<Employee> getAll(){
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		List<Employee> result = new ArrayList<>();
		List<Employee> temp1 = mapper.getAll();
		List<Employee> temp2 = mapper.getAllindiv();
		if (temp1.size()==temp2.size()) {
			for(int i=0;i<temp1.size();i++) {
				Employee tempemp1 = temp1.get(i);
				Employee tempemp2 = temp2.get(i);
				if (tempemp1.getEmpno()==tempemp2.getEmpno() & tempemp1.getDeptno()==tempemp2.getDeptno()) {
					tempemp2.setFname(tempemp1.getFname());
					tempemp2.setMname(tempemp1.getMname());
				}else {
					System.out.println("Critical Error! empno&deptno doesn't match!");
				}
				result.add(tempemp2);
			}
		}else {
			System.out.println("Critical Error! The Number of record doesn't match!");
		}
		return result;
	}
	public Map<Integer, String> fired (List<Integer> empnums) {
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		Map<Integer, String> result = new HashMap<>();
		for (int i=0 ; i<empnums.size() ; i++) {
			String tempstr = "failed to delete";
			int tempint = empnums.get(i);
			int temp = mapper.fired(tempint);
			if (temp==1) {
				tempstr = "successfully deleted";
			}
			result.put(tempint, tempstr);
		}
		return result;
	}
	public String insert(Employee emp) {
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		String result = "registration failed";
		if (mapper.insert(emp)==1) {
			result = "registration succeed";
		};
		return result;
	}
	public String inputdetails(Employee emp) {
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		String result = "registration failed";
		if(mapper.inputdetails(emp)==1) {
			result = "registration succeed";
		}
		return result;
	}
	public Map<Integer,String> promotion (List<Integer> empnums) {
		Map<Integer, String> result = new HashMap<Integer, String>();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		for (int i=0; i<empnums.size();i++) {
			String tempstr = "";
			int tempint = mapper.promotion(empnums.get(i));
			if (tempint==1) {
				tempstr = "promotion applied";
			}
			result.put(empnums.get(i), tempstr);
		}
		return result;
	}
	public Map<Integer,String> salup (List<Integer> empnums) {
		Map<Integer, String> result = new HashMap<Integer, String>();
		
		return result;
	}
	public int update (Employee emp) {
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		int result = mapper.update(emp);
		return result;
	}
}
