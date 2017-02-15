package security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AuthenticationProviderImpl implements AuthenticationProvider{
	
	private UserDetailsService userDetailsService;
	
	 public void setUserDetailsService(UserDetailsService userDetailsService) {
		 
	        this.userDetailsService = userDetailsService;
	 }	 
	 
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		  UserDetails userDetails = this.userDetailsService.loadUserByUsername(authentication.getName());
	        if (userDetails != null && (authentication.getCredentials().toString()).equals(
	                        userDetails.getPassword())) {
	            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	        }
			throw new BadCredentialsException("Username or password are not correct."); //We need to encrypt the passwords, but It will be better to leave that by the moment 
			 
	}

	@Override
	public boolean supports(Class<? extends Object> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
