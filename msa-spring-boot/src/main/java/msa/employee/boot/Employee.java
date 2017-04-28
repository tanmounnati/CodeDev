package msa.employee.boot;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
	
	@Id
	public String id;
	
	public String email;
	public String fullName;
	public String managerEmail;
}
