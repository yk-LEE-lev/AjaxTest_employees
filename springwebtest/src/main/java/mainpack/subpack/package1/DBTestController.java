package mainpack.subpack.package1;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mainpack.subpack.package1.dao.EmployeeRepository;
import mainpack.subpack.package1.vo.Employee;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DBTestController {
	@Autowired
	EmployeeRepository repository;
	
	@RequestMapping(value = "getAll", method = RequestMethod.POST)
	public @ResponseBody List<Employee> getAll() {
		List<Employee> result = repository.getAll();
		for (Employee employee : result) {
			System.out.println("formulated"+ employee.toString());
		}
		return result;
	}
	@RequestMapping(value="fired", method = RequestMethod.GET)
	public @ResponseBody Map<Integer, String> fired(List<Integer> empnums) {
		Map<Integer, String> result = repository.fired(empnums);
		return result;
	}
	@RequestMapping(value="insert", method = RequestMethod.GET)
	public @ResponseBody String insert() {
		return "insert";
	}
	@RequestMapping(value="inputdetails", method = RequestMethod.GET)
	public @ResponseBody String inputdetails() {
		return "inputdetails";
	}
	@RequestMapping(value="promotion", method = RequestMethod.GET)
	public @ResponseBody String promotion() {
		return "inputdetails";
	}
	@RequestMapping(value="salup", method = RequestMethod.GET)
	public @ResponseBody String salup() {
		return "salup";
	}
	@RequestMapping(value="update", method = RequestMethod.GET)
	public @ResponseBody String update() {
		return "update";
	}
	@RequestMapping(value="updateindiv", method = RequestMethod.GET)
	public @ResponseBody String updateindiv() {
		return "updateindiv";
	}
	
}
