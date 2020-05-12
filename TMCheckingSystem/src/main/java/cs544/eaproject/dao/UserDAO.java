package cs544.eaproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.eaproject.domain.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	 User findByEmail(String email);
}
