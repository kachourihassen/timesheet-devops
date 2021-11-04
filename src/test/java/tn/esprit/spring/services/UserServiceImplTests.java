package tn.esprit.spring.services;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@SpringBootTest
class UserServiceImplTest  {


	@Autowired
	IUserService us;
	@Test
	public void testRetrieveAllUsers() {
	List<User> listUsers = us.retrieveAllUsers();
	Assertions.assertEquals(2, listUsers.size());
	}
	public void testAddUser() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		User u = new User("hassen7","hassen7",d,Role.INGENIEUR);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
		
	}
	public void testModifyUser() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		User u = new User(2L,"hassen1zzzz","hassen1",d,Role.INGENIEUR);
		User userupdated = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userupdated.getLastName());
		
	}
	public void testDeleteUser(){
		us.deleteUser("5");
		Assertions.assertNull(us.retrieveUser("5"));
	}
	public void testRetrieveUser(){
		User userRetrieved = us.retrieveUser("2");
		Assertions.assertEquals(2l, userRetrieved.getId().longValue());
	}
	private static final Logger L = LogManager.getLogger(UserServiceImplTest.class);
	
	@Test
	public void testAll(){
		try{
			L.info("In testAll()");
			 testRetrieveAllUsers();
			 testAddUser();
			 testModifyUser();
			 testDeleteUser();
			 testRetrieveUser();
			 L.info("Out of testAll()");
		}catch(Exception e){
		L.error("Out of testAll() wirh Errors : " + e);
		}
	}
	
}
