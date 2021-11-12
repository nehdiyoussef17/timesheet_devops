package tn.esprit.spring.services;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
 class UserServiceImplTest {
	@Autowired
	IUserService us;
	@Test
	@Order(1)
	 void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");

		us.addUser(new User("Youssef", "NEHDI1", d,Role.INGENIEUR));
		List<User> listUsers= us.retrieveAllUsers();
		Assertions.assertEquals(3, listUsers.size());
	}

	@Test
	@Order(2)
	 void testRetrieveUser() {
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(3, listUsers.size());
	}
	
	@Test
	@Order(3)
	 void testUpdateUser() {
		List<User> listUsers = us.retrieveAllUsers();
		User e = listUsers.get(0);
		e.setLastName("NEHDI2");
		us.updateUser(e);
		listUsers = us.retrieveAllUsers();
		Assertions.assertEquals("NEHDI2", listUsers.get(0).getLastName());
	}
	@Test
	@Order(4)
	 void testDeleteUser() {
		List<User> listUsers = us.retrieveAllUsers();
		us.deleteUser(listUsers.get(0).getId().toString());
		listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(2,listUsers.size());
	}

}