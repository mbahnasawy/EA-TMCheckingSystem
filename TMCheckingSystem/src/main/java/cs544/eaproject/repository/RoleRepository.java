package cs544.eaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.eaproject.domain.Reservation;
import cs544.eaproject.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Role findByRoleName(String roleName);

}
