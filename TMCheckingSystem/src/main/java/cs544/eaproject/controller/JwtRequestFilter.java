package cs544.eaproject.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import cs544.eaproject.integration.Jwt;
import cs544.eaproject.service.UserService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	private UserService userService;
	
	@Autowired
	private Jwt jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authoriztionHeader = request.getHeader("Authorization");
		String email = null;
		String jwt = null;
		if(authoriztionHeader != null && authoriztionHeader.startsWith("Bearer")) {
			jwt = authoriztionHeader.substring(7);
			email = jwtService.extractUsername(jwt);
		}
		if(email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetail = userService.loadUserByUsername(email);
			if(jwtService.validateToken(jwt, userDetail)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			}
		}
		filterChain.doFilter(request, response);
	}

}
