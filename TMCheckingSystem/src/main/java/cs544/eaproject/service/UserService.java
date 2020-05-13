package cs544.eaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cs544.eaproject.dao.UserDAO;
import cs544.eaproject.domain.User;
import cs544.eaproject.util.JwtUserDetails;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDAO.findByEmail(email);
		return new JwtUserDetails(user.getId(), user.getEmail(), user.getPassword(),
				user.getUserRole().iterator().next().getRoleName());	
		}
}
