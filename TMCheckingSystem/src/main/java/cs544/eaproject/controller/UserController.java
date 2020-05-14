package cs544.eaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs544.eaproject.integration.Jwt;
import cs544.eaproject.service.UserService;
import cs544.eaproject.service.dto.AppointmentDto;
import cs544.eaproject.service.dto.AuthRequest;
import cs544.eaproject.service.dto.AuthResponse;
import cs544.eaproject.service.dto.ReservationDto;
import cs544.eaproject.service.dto.UserDto;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private Jwt jwt;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid email/password");
		}
		final UserDetails user = userService.loadUserByUsername(authRequest.getUsername());
		String token = jwt.generateToken(user.getUsername());
		return ResponseEntity.ok(new AuthResponse(token, "Login success", HttpStatus.OK.value()));
	}

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", produces = { "application/json" })
	@Secured({ "ROLE_ADMIN" })
	public UserDto createUser(@RequestBody UserDto userDto) throws Exception {

		return userService.createUser(userDto);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	@Secured({ "ROLE_ADMIN" })
	public Boolean deleteUser(@PathVariable long userId) throws Exception {

		return userService.deleteUser(userId);
	}
}
