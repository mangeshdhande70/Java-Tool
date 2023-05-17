package com.Employee.MyController;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class MyController {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	SearchRepo searchRepo;


	@ApiIgnore
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}


	@GetMapping("/allEmployee")
	public List<Employee> getAllEmployee(){

		return employeeRepo.findAll();
	}

	@GetMapping("/allEmployee/{text}")
	public List<Employee> search(@PathVariable String text){

		return searchRepo.findByUnit(text);
	}

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {

		return employeeRepo.save(employee);
	}

}
