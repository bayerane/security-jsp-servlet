package sn.zone01dakar.security.service;

import java.util.List;

import sn.zone01dakar.security.dao.UserDao;
import sn.zone01dakar.security.dto.UserDto;
import sn.zone01dakar.security.entity.UserEntity;
import sn.zone01dakar.security.mapp.UserMapper;

public class UserService implements IUserService {

	private UserDao userDao = new UserDao();
	
	@Override
	public List<UserDto> getAll() {
		
		return UserMapper.listUserEntityToListUserDto(userDao.list(new UserEntity()));
	}

}
