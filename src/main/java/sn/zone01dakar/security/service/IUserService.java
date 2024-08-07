package sn.zone01dakar.security.service;

import java.util.List;

import sn.zone01dakar.security.dto.UserDto;

public interface IUserService {
	
	public List<UserDto> getAll();
}
