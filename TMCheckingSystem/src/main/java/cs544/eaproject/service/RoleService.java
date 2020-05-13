package cs544.eaproject.service;

import java.util.List;

import cs544.eaproject.domain.Reservation;
import cs544.eaproject.domain.Role;
import cs544.eaproject.service.dto.ReservationDto;
import cs544.eaproject.service.dto.RoleDto;

public interface RoleService {
	
	public List<RoleDto> findAllRoles();
	
	public RoleDto createRole(RoleDto roleDto);
	
	List<RoleDto> convertEntityListToResponseList(List<Role> entityList);
	
	public RoleDto deleteRole(String roleName);

}
