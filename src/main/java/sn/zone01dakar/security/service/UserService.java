package sn.zone01dakar.security.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public boolean save(UserDto userDto) {
		
		return userDao.save(UserMapper.toUserEntity(userDto));
	}

	@Override
	public Optional<UserDto> login(String email, String password) {
		
		Optional<UserEntity> userEntity = userDao.login(email, password);
		
		if (userEntity.isPresent()) {
			UserEntity user = userEntity.get();
			return Optional.of(UserMapper.toUserDto(user));
		}else {
			return Optional.empty();
		}
	}

}
