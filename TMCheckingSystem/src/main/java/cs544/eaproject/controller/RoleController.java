package cs544.eaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs544.eaproject.service.RoleService;
import cs544.eaproject.service.dto.RoleDto;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public List<RoleDto> getRoles(){
		return roleService.findAllRoles();
	}
	
	@PostMapping("/create")
	public RoleDto createRole(@RequestBody RoleDto roleDto) {
		return roleService.createRole(roleDto);
	}

	@DeleteMapping(value = "/delete",params = "Role")
	public RoleDto deleteRole(@RequestParam String Role) {
		
		return roleService.deleteRole(Role);
	}
}
