package sbjp.rest.sbjprestful.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbjp.rest.sbjprestful.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	User findByuserName(String username);
}
