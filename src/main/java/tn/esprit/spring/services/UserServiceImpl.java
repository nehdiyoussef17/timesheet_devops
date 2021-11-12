package tn.esprit.spring.services;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("In method retrieveAllUsers :"); 
			users = (List<User>) userRepository.findAll();  
			l.debug("connexion à la DB Ok:");
			
			
			l.info("Out of method retrieveAllUsers with success");
		}catch (Exception e) {
			l.error("");
		}
		return users;
	}
	
	@Override
	public User addUser(User u) {
		return userRepository.save(u); 
	}

	@Override 
	public User updateUser(User u) { 
		return userRepository.save(u); 
		  
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(Long.parseLong(id)); 
	}

	@Override
	public User retrieveUser(String id) {
		
		return userRepository.findById(Long.parseLong(id)).orElse(null); 
	}

}
