package sbjp.rest.sbjprestful.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sbjp.rest.sbjprestful.repositories.UserRepository;

public class Utils {
	@Autowired
	private static UserRepository userRepository;

	public static BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	public static String GetUserName() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		return username;

	}

	public static int GetIdUser() {

		int idUser = 0;
		idUser = userRepository.findByuserName(GetUserName()).getId();

		return idUser;

	}

	public static String convertDateToddMMyyyy(Date date) {
		if (date == null) {
			return "";
		}

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(date);

	}
}
