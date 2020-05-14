package cs544.eaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.eaproject.domain.Role;
import cs544.eaproject.domain.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}