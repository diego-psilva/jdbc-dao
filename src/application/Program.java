package application;


import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller find by id ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller find by DepartmentId ===");			
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
	    list.forEach(System.out::println);
	    
	    System.out.println("\n=== Test 3: seller find all ===");		
	    list = sellerDao.findAll();
	    list.forEach(System.out::println);
	    

	}

}
