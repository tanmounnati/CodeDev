package msa.employee.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public Employee create(@RequestBody Employee employee) {
		Employee result = employeeRepository.save(employee);
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{employeeId}")
	public Employee getEmployee(@PathVariable String employeeId) throws RuntimeException{
		Employee employee = employeeRepository.findOne(employeeId);
		if (employee!=null)
			return employee;
		else
			throw new RuntimeException("No employee Found!");
	}
	
}
