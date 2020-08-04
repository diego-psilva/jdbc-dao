package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartamentDao depDao = DaoFactory.createDepartmentDao();
/*		
		System.out.println("=== Test 1: department insert ===");
		Department dep = new Department(null,"Food");
		depDao.insert(dep);
		System.out.println("Department inserted: "+dep);
		
		System.out.println("\n=== Test 2: department update ===");
		dep.setName("kitchen");
		dep.setId(1);
		depDao.update(dep);
		System.out.println("Done! Department updated");
		
		System.out.println("\n=== Test 3: department delete ===");
		System.out.println("Enter department id for delete");
		depDao.deleteById(sc.nextInt());
		System.out.println("Done! Department deleted");
		
		System.out.println("\n=== Test 4: department findById ===");
		Department dep = depDao.findById(2);
		System.out.println(dep);
*/		
		System.out.println("\n=== Test 5: department findAll ===");
		List<Department> list = new ArrayList<>();
		list = depDao.findAll();
		list.forEach(System.out::println);
		
		
		
		
		sc.close();
	}

}
