package cs544.eaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.eaproject.dao.UserDAO;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
}
