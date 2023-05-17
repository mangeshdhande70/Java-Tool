package com.mangesh.persistent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;

import com.mangesh.dto.Employee;
import com.mangesh.jdbcconnection.JdbcConnection;
import com.mangesh.studentfactory.EmployeeFactory;



public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public String addingEmployee(String name, String unit, String doj , String dob , String photoPath , String idProofPath) {
		
		String sqlQuery = "INSERT INTO employee(`empname`,`unit`,`doj`,`dob`,`photo`,`idproof`)VALUES (?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		java.util.Date date = null;
		java.sql.Date dateSql = null;
		int rowAffected = 0;
		
		try {
			
			connection = JdbcConnection.getJdbcConnection();
			if (connection!=null)
					preparedStatement = connection.prepareStatement(sqlQuery);
			
			if (preparedStatement!=null) {
				preparedStatement.setString(1, name);
				preparedStatement.setString(2,unit);	
			}
			
	        if (doj!=null) {
	        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
				date = simpleDateFormat.parse(doj);
				long date1 = date.getTime();
				dateSql = new Date(date1);
			}
	        
	        
	        preparedStatement.setDate(3, dateSql);
	        
	        
	        dateSql = java.sql.Date.valueOf(dob);
	        preparedStatement.setDate(4, dateSql);
	          
	   //  For Image Set     
	        
	   //   FileInputStream fileInputStream = new FileInputStream(new File(photoPath));
	        preparedStatement.setBinaryStream(5,new FileInputStream(new File(photoPath)));
	        
	       
	  //    For PDF or text set  
	  //    FileReader fileReader = new FileReader(new File(idProofPath));
	        preparedStatement.setCharacterStream(6, new FileReader(new File(idProofPath)));
	        
	        if (preparedStatement!=null) 
	        	rowAffected = preparedStatement.executeUpdate();
			
	        
	        if(rowAffected!=0)
	           return "success";
	  	
		} catch (SQLException | IOException |ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcConnection.cleanUpResources(connection, preparedStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	return "failure";
	
	}
	

	@Override
	public Employee searchEmployeeById(Integer empId) {
		
		String sqlQuery = "SELECT * FROM employee WHERE empid = ?";
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet =null;
		
		Employee employee = EmployeeFactory.getEmployee();
			
		try {
			
		// Established connection
			connection = JdbcConnection.getJdbcConnection();
		    if (connection!=null)				
				preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, empId);
			
			
			
			if (preparedStatement!=null)
				resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				
				employee.setEmpid(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setUnit(resultSet.getString(3));
				
				// setting Object Value of Date
				
		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
		        employee.setDoj(simpleDateFormat.format(resultSet.getDate(4)));
		        employee.setDob(simpleDateFormat.format(resultSet.getDate(5)));
		        
	
		       // Setting Object Value of image
		        
//		        int i =  inputStream.read();
//		        while (i!=-1) {
//		        	 fileOutputStream.write(i);
//		        	 i = inputStream.read();
//				}
		        
		        
		        File file = new File("MangeshPhot.jpg");
		        FileOutputStream fileOutputStream = new FileOutputStream(file);
		        InputStream inputStream = resultSet.getBinaryStream(6);
		        IOUtils.copy(inputStream, fileOutputStream); // it gets from apache jar
		        employee.setPhotoPath(file.getAbsolutePath());
		        fileOutputStream.close();


	            // 1st method to setting object value of pdf or text
//		         
//		         file = new File("IdProof.pdf");
//		         FileWriter fileWriter = new FileWriter(file);
//		         Reader reader = resultSet.getCharacterStream(7);
//		         i = reader.read();
//		         while (i!=-1) {
//		        	fileWriter.write(i);
//					i = reader.read();	
//				}
//	             
	    
		      // Setting Object Value of PDF or TEXT Document
		        
		        Reader reader = resultSet.getCharacterStream(7);
		        File file1 = new File("ak.pdf");
		        FileWriter fileWriter = new FileWriter(file);
		        IOUtils.copy(reader, fileWriter);
		        fileWriter.close();
		        employee.setIdProofPath(file1.getAbsolutePath());
	            
	            return employee;
			}
		
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcConnection.cleanUpResources(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	return employee;
	
	}

	@Override
	public String deleteEmployee(Integer empId) {
		
		String sqlQuery = "DELETE FROM employee WHERE empid =?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rowAffected = 0;
		
		try {
			
			   connection = JdbcConnection.getJdbcConnection();
			   if (connection!=null) 
				   preparedStatement = connection.prepareStatement(sqlQuery);
			
			//  Setting Placeholder(?)
	 			preparedStatement.setInt(1, empId);
				
				
				if (preparedStatement!=null)
				   rowAffected = preparedStatement.executeUpdate();
					
				if (rowAffected!=0)
					return "success";
		
		}catch (SQLException | IOException e) {
            e.printStackTrace();
		}finally {
			try {
				JdbcConnection.cleanUpResources(connection, preparedStatement, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return "not found";
	}

	@Override
	public String updateEmployee(Integer empId, String doj, String dob, String photoPath,String idProofPath) {
		
		String sqlUpdateQuery = "UPDATE employee SET doj = ? , dob = ? , photo = ? , idproof = ? where empid = ?";
		Connection connection = null;
		PreparedStatement pr = null;
		java.util.Date doj1 = null;
		java.sql.Date dateSql = null;
		int rowAffected = 0;
		
		try {
			
			connection = JdbcConnection.getJdbcConnection();
		    if (connection!=null) 
				pr = connection.prepareStatement(sqlUpdateQuery);
	
			
			// If date not in SQL Format.
			if (doj!=null) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
				doj1 = simpleDateFormat.parse(doj);
				long doj2 = doj1.getTime();
			    dateSql = new Date(doj2); 
			}
			
			pr.setDate(1, dateSql);
			
		 // Already in SQL Format Date
			dateSql = Date.valueOf(dob);
			pr.setDate(2, dateSql);
			
			
	    // Setting Placeholder
          pr.setBinaryStream(3, new FileInputStream(new File(photoPath)));
          pr.setCharacterStream(4, new FileReader(new File(idProofPath)));
          pr.setInt(5, empId);
          
          
        // Sending Query  
          if (pr!=null) 
        	 rowAffected =  pr.executeUpdate();
			
	
         if (rowAffected!=0) 
			return "success";
        
         
		} catch (SQLException | IOException |ParseException e) {
			e.printStackTrace();
			} finally {
			try {
				JdbcConnection.cleanUpResources(connection, pr, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
	return "failure";
	}
	
	
	
	public ArrayList<Employee> getAllEmployees(){
		
		String sqlQuery = "SELECT `empid`,`empname`,`unit`,`doj`,`dob` FROM employee";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		
		ArrayList<Employee> arrayList = new ArrayList<>();
		
		try {
			connection = JdbcConnection.getJdbcConnection();
			
			if (connection!=null) 
				preparedStatement = connection.prepareStatement(sqlQuery);
			
			
			if (preparedStatement!=null) 
				resultSet= preparedStatement.executeQuery();
			
			
			if (resultSet!=null) {
				
				while (resultSet.next()) {
				
				Employee employee = new Employee();
					
				employee.setEmpid(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setUnit(resultSet.getString(3));
				
				if (resultSet.getDate(4)!=null) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
					String doj = simpleDateFormat.format(resultSet.getDate(4));
					String dob = simpleDateFormat.format(resultSet.getDate(5));
					employee.setDoj(doj);
					employee.setDob(dob);
					
				}
				
				arrayList.add(employee);
//					arrayList.add(resultSet);
				
		
				}
				
				if (arrayList!=null) 
					return arrayList;
				
			}
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JdbcConnection.cleanUpResources(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
