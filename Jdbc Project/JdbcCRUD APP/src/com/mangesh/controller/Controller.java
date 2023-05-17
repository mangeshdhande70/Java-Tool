package com.mangesh.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.mangesh.ServiceFactory.EmployeeServiceFactory;
import com.mangesh.dto.Employee;
import com.mangesh.service.IEmployeeService;
import com.mangesh.studentfactory.EmployeeFactory;


public class Controller {
	
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);

		insertionOperation(scanner);
		
		updateOperation(scanner);
		
		selectOperation(scanner);
		
		deleteOpearation(scanner);
		
		getAllEmployee();
		
		scanner.close();
        
    
	}
	
	
	
	private static  void insertionOperation(Scanner scanner) {
		
	
		
		IEmployeeService iEmployeeService = EmployeeServiceFactory.getEmployeeService();
		
			
			String msg = "";
			
			Employee employee = EmployeeFactory.getEmployee();
			
			
			System.out.println("Enter Your Name");
			employee.setName(scanner.next());
			
			System.out.println("Enter Your Unit");
			employee.setUnit(scanner.next());
			
			System.out.println("Enter Date Of Joining in (dd-MM-yyyy) format");
			employee.setDoj(scanner.next());
			
			System.out.println("Enter Date Of Birth in (yyyy-MM-dd) format");
			employee.setDob(scanner.next());
			
			
			System.out.println("Select Profile Photo");
			employee.setPhotoPath(scanner.next());
			
			
			System.out.println("Select Id Proof");
			employee.setIdProofPath(scanner.next());
			
		
			msg = iEmployeeService.addingEmployee(employee.getName(), employee.getUnit(), employee.getDoj(), employee.getDob(), employee.getPhotoPath(),
																									employee.getIdProofPath());
			
			if (msg.equalsIgnoreCase("success"))
				System.out.println("record inserted succesfully");
		    else 
				System.out.println("record insertion failed....");
					
//		    scanner.close();
			
	
	}

 		// For Updating Student Details
		
	private static	void updateOperation(Scanner scanner) {
		
		    String msg = "";
//		    Scanner scanner = new Scanner(System.in);
			IEmployeeService iStudentService = EmployeeServiceFactory.getEmployeeService();
			Employee employee = EmployeeFactory.getEmployee();
			
			
			System.out.println("Enter Your Id");
			int id = scanner.nextInt();
			employee.setEmpid(id);
		
			
			System.out.println("Enter Date Of Joining in (dd-MM-yyyy) format");
			String doj = scanner.next();
			employee.setDoj(doj);
			
			System.out.println("Enter Date Of Birth in (yyyy-MM-dd) format");
			String dob = scanner.next();
			employee.setDob(dob);
			
			
			System.out.println("Select Profile Photo");
			String photoPath = scanner.next();
			employee.setPhotoPath(photoPath);
			
			
			System.out.println("Select Id Proof");
			String filepath = scanner.next();
			employee.setIdProofPath(filepath);
			
			
			msg = iStudentService.updateEmployee(employee.getEmpid(), employee.getDoj(), employee.getDob(), employee.getPhotoPath(), employee.getIdProofPath());
			
		
			if (msg.equalsIgnoreCase("success")) 
				System.out.println("record updated Successfully......");
			else
				System.out.println("record updation failed......");
		
			
//			scanner.close();
			
		}
		
	
	private	static void selectOperation(Scanner scanner) {
			
		
//		   Scanner scanner = new Scanner(System.in);
	
			IEmployeeService iEmployeeService = EmployeeServiceFactory.getEmployeeService();
			
			System.out.println("Enter Your Id");		
			int id = scanner.nextInt();
			Employee employee  = iEmployeeService.searchEmployeeById(id);
			
		    System.out.println(employee);
						
		  if(employee.getEmpid()!=null) {		
			
				   System.out.println("Employee Id\tEmployee Name\tUNit\tDOJ\tDOB");
				   System.out.print(employee.getEmpid()+"\t"+employee.getName()+"\t"+employee.getUnit()+
						   								  "\t"+employee.getDoj()+"\t"+employee.getDob());
				   
				   System.out.println();
				   System.out.println(employee.getPhotoPath()+"\t");
				   System.out.print(employee.getIdProofPath()+"\t");		
				   
		  }else {
			System.out.println("Record Not Found For given id :: "+id);
		  }
		
//		scanner.close();
		
		
	}
	
	
	private static void deleteOpearation(Scanner scanner) {
			
		String msg = "";
		IEmployeeService iEmployeeService =  EmployeeServiceFactory.getEmployeeService();
//		Scanner scanner =new Scanner(System.in);
			
		
		System.out.println("Enter Your Id");
		int id = scanner.nextInt();
		
	    msg = iEmployeeService.deleteEmployee(id);
		
		if (msg.equalsIgnoreCase("success")) 
			System.out.println("your data deleted successfulyy");
		else if(msg.equalsIgnoreCase("not found"))
			System.out.println("Record not available for given Id "+id);
		else 
			System.out.println("failed to delete your data");
		

	}
	
	
	
	
	private static void getAllEmployee() {
		
		IEmployeeService iEmployeeService =  EmployeeServiceFactory.getEmployeeService();
		
		List<Employee> list =  iEmployeeService.getAllEmployee();
		
		if (list!=null) {
			
			System.out.println(" Id\tEmployee Name\t   Unit \t  DOJ \t\t   DOB");
			

		// Using While Iterate the result	
			
			Iterator<Employee> iterator = list.iterator();
			
			while(iterator.hasNext()) {
                Employee employee = (Employee) iterator.next();
				System.out.println(" "+employee.getEmpid()+"\t    "+employee.getName()+"\t   "+employee.getUnit()+
						   "\t\t"+employee.getDoj()+"\t"+employee.getDob());
				
			}
			
			
			System.out.println("\n\n");
			
		// Using For each
			
			for (Iterator<Employee> iterator2 = list.iterator(); iterator2.hasNext();) {
				Employee employee = (Employee) iterator2.next();
				System.out.println(" "+employee.getEmpid()+"\t    "+employee.getName()+"\t   "+employee.getUnit()+
						   "\t\t"+employee.getDoj()+"\t"+employee.getDob());
			}
			
		}else {
			System.out.println("Record not available..............");
		}
		
	}
	
}
