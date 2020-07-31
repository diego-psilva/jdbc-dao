package application;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller find by id ===");
		Seller seller1 = sellerDao.findById(1);
		System.out.println(seller1);
		
		System.out.println("\n=== Test 2: seller find by DepartmentId ===");			
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
	    list.forEach(System.out::println);
	    
	    System.out.println("\n=== Test 3: seller find all ===");		
	    list = sellerDao.findAll();
	    list.forEach(System.out::println);
	    
	    System.out.println("\n=== Test 4: seller insert ===");
	    Seller newSeller = new Seller (null,"Pedro","pedro@gmail,com",new Date(),5000.0,new Department(2,null));
	    sellerDao.insert(newSeller);	    
	    System.out.println("Inserted! New Id: "+newSeller.getId());
	    
	    System.out.println("\n=== Test 5: seller update ===");
	    seller1.setName("Carlos");
	    sellerDao.update(seller1);
	    System.out.println("Update completed");
	    
	    System.out.println("\n=== Test 6: seller delete ===");
	    System.out.println("Enter id for delete test");
	    int id = sc.nextInt();
	    sellerDao.deleteById(id);
	    
	    sc.close();
	    
	    
	}

}
