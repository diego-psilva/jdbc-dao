package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartamentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: department insert===");
		Department dep = new Department(null,"Food");
		depDao.insert(dep);
		System.out.println("Department inserted: "+dep);
		
		sc.close();
	}

}
