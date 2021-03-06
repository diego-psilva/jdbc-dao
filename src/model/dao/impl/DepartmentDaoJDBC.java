package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartamentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartamentDao{
	
	private Connection conn;
	
	public DepartmentDaoJDBC (Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO department"
					+ "(Name)"
					+ "VALUES (?);", st.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			
			int rows = st.executeUpdate();
			
			if (rows>0) {
				
				ResultSet rs = st.getGeneratedKeys();	
				
				if(rs.next()) {
					obj.setId(rs.getInt(1));
				}
				
				DB.closeResultSet(rs);
			}else {
				throw new DbException("Inexpected error: no rows affected" );
			}
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
		
	}

	@Override
	public void update(Department obj) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"UPDATE department " + 
					"SET Name = ? " + 
					"WHERE id = ?;");
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"DELETE FROM department " + 
					"WHERE Id = ?;");
			
			st.setInt(1, id);
			
			int rows = st.executeUpdate();
			
			if (rows==0) {
				throw new DbException("Inexpected error: no rows deleted");
			}
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs =  null;
		
		try {
			st = conn.prepareStatement("SELECT * " + 
					"FROM department " + 
					"WHERE id = ?;");
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			Department dep = new Department();
			
			if (rs.next()) {
				dep.setId(rs.getInt("Id"));
				dep.setName(rs.getString("Name"));

			}
		
			return dep;
			
		}catch (SQLException e) {
			throw new DbException (e.getMessage());
		
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
	}

	@Override
	public List<Department> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			st = conn.prepareStatement("SELECT * " + 
					"FROM department;");
			
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();
				
			while (rs.next()) {
				
				list.add(new Department(rs.getInt("Id"),rs.getString("Name")));
				
			}
			return list;
		
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
	}

}
