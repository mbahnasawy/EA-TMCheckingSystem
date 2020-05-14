package cs544.eaproject.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cs544.eaproject.domain.Appointment;
import cs544.eaproject.domain.Role;
import cs544.eaproject.domain.User;
import cs544.eaproject.repository.RoleRepository;
import cs544.eaproject.repository.UserRepository;
import cs544.eaproject.service.dto.AppointmentDto;
import cs544.eaproject.service.dto.UserDto;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role role : user.getUserRole()) {
			 authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
	}
	
	public UserDto createUser(UserDto userDto) {
		
		User user = modelMapper.map(userDto, User.class);
		Role role = roleRepository.findById((new Long(userDto.getRoleId()))).get();
		user.addRole(role);
		userRepository.save(user);

		return convertEntityToResponse(user);
	}
	
	public Boolean deleteUser(long userId) {
		
		userRepository.deleteById(userId);
		return true;
	}
	
	public UserDto convertEntityToResponse(User entity) {
		// TODO Auto-generated method stub
		if (null == entity) {
			return null;
		} else {
			return modelMapper.map(entity, UserDto.class);
		}
	}
	
}
