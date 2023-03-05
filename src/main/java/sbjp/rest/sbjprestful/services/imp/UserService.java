package sbjp.rest.sbjprestful.services.imp;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sbjp.rest.sbjprestful.clientsever.request.UserRequest;
import sbjp.rest.sbjprestful.common.Utils;
import sbjp.rest.sbjprestful.entities.CustomUserDetails;
import sbjp.rest.sbjprestful.entities.User;
import sbjp.rest.sbjprestful.repositories.IUserRepository;
import sbjp.rest.sbjprestful.services.IUserService;

@Component
public class UserService implements IUserService{

	@Autowired
	private IUserRepository userRepository;

	// @Autowired
	// private UserConverter userConverter;

	@Override
	public List<User> getAllUser() {
		List<User> users = userRepository.findAll();
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	@Transactional
	public boolean add(UserRequest request) {

		User check = null;
		User user = new User();
		user.setUserName(request.getUserName());
		user.setPassword(request.getPassword());
		user.setRole("ROLE_USER");

		check = userRepository.save(user);
		return check != null ? true : false;
	}

	
	// JWTAuthenticationFilter sẽ sử dụng hàm này
    @Transactional
    public UserDetails loadUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new CustomUserDetails(user);
    }

	@Override
	public User findByUserName() {
		return userRepository.findByuserName(Utils.GetUserName());
	}

	@Override
	@Transactional
	public boolean update(int userId,UserRequest request) {
		User check = null;
		User user = userRepository.getById(userId);
		if (Objects.nonNull(user)) {
			user.setPassword(Utils.passwordEncoder().encode(request.getPassword()));
			check = userRepository.save(user);
		}
		return check != null ? true : false;
	}

}
