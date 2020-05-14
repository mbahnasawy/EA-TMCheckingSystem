package cs544.eaproject.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {
	@Bean
	@Primary
	public UserDetailsService userDetailsService() {
		List<GrantedAuthority> authoritiesAdmin = new ArrayList<GrantedAuthority>();
		authoritiesAdmin.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		User admin = new User("admin", "123", authoritiesAdmin);
		
		List<GrantedAuthority> authoritiesProvider = new ArrayList<GrantedAuthority>();
		authoritiesProvider.add(new SimpleGrantedAuthority("ROLE_PROVIDER"));
		User provider = new User("provider", "123", authoritiesProvider);
		
		List<GrantedAuthority> authoritiesConsumer = new ArrayList<GrantedAuthority>();
		authoritiesConsumer.add(new SimpleGrantedAuthority("ROLE_CONSUMER"));
		User consumer = new User("consumer", "123", authoritiesConsumer);

		return new InMemoryUserDetailsManager(Arrays.asList(admin, provider, consumer));
	}
}
