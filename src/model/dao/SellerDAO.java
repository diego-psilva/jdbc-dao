package model.dao;

import model.entities.Seller;

public interface SellerDAO {
	
	void insert (Seller obj);
	void update (Seller obj);
	void deleteById (Integer id);
	Seller findById (Integer id);
	List<Seller> findAll ();

}
