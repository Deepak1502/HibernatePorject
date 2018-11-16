package com.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.entity.UserRecord;


@Service

public class DataService {

	@Autowired  
	JdbcTemplate jdbc; 
	public void addUser(UserRecord userRecord){
		String query="insert into user value('"+userRecord.getName()+"', '"+userRecord.getEmail()+"',"+userRecord.getId()+")";
		jdbc.update(query); 
	} 
	public List<UserRecord> getUser(){
	return	 jdbc.query("select * from user",new ResultSetExtractor<List<UserRecord>>() {
			 
			@Override
			public List<UserRecord> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<UserRecord> usrd=new ArrayList<UserRecord>();
				
				while(rs.next()) {
					UserRecord userRecord=new UserRecord();
					userRecord.setName(rs.getString(1));
					 userRecord.setEmail(rs.getString(2));
					 userRecord.setId(rs.getInt(3));
					 usrd.add(userRecord);
				}
				
				 
				 return usrd;
			}
		});
		
	}
	
}
