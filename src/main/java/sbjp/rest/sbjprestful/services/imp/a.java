package sbjp.rest.sbjprestful.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sbjp.rest.sbjprestful.entities.CustomUserDetails;
import sbjp.rest.sbjprestful.entities.User;
import sbjp.rest.sbjprestful.repositories.IUserRepository;

@Component
public class a  implements UserDetailsService{
	@Autowired
	private IUserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Kiểm tra xem user có tồn tại trong database không?
		User user = userRepository.findByuserName(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		System.out.println(user.toString());
		return new CustomUserDetails(user);
	}
}
