package in.ineuron.service.salary;

import in.ineuron.dto.EmployeeDto.EmployeeDto;

public interface SalaryDetailsGenerator {
	public void generateSalaryDetails(EmployeeDto dto);
}
