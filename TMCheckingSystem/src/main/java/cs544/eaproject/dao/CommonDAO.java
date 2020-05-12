package cs544.eaproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import cs544.eaproject.domain.Appointment;

//@Repository
//public interface CommonDAO<T> extends JpaRepository<T, Integer>{
//	
//}

@Repository
public interface CommonDAO{
	void delete(long id);
}
