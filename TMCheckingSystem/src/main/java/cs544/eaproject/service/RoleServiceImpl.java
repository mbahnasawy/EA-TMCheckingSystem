package cs544.eaproject.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.eaproject.domain.Role;
import cs544.eaproject.repository.RoleRepository;
import cs544.eaproject.service.dto.ReservationDto;
import cs544.eaproject.service.dto.RoleDto;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<RoleDto> findAllRoles() {
		// TODO Auto-generated method stub
		return convertEntityListToResponseList(roleRepository.findAll());
	}

	@Override
	public RoleDto createRole(RoleDto roleDto) {
		// TODO Auto-generated method stub
		Role role = modelMapper.map(roleDto, Role.class);
		roleRepository.save(role);
		return modelMapper.map(role, RoleDto.class);
	}
	@Override
	public RoleDto deleteRole(String RoleName) {
		// TODO Auto-generated method stub
		Role role =roleRepository.findByRoleName(RoleName);
		roleRepository.delete(role);
		return modelMapper.map(role, RoleDto.class);
	}
	@Override
	public List<RoleDto> convertEntityListToResponseList(List<Role> entityList) {
		// TODO Auto-generated method stub
		if(null == entityList)
			return null;
		else {
			return entityList.stream()
					.map(entity -> modelMapper.map(entity, RoleDto.class))
					.collect(Collectors.toList());
					
		}
	}

}
