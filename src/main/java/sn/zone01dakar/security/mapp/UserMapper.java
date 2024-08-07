package sn.zone01dakar.security.mapp;

import java.util.List;
import java.util.stream.Collectors;

import sn.zone01dakar.security.dto.UserDto;
import sn.zone01dakar.security.entity.UserEntity;

public class UserMapper {
	
	public static List<UserDto> listUserEntityToListUserDto(List<UserEntity> users){
		
		return users.stream()
				.map(user -> toUserDto(user))
				.collect(Collectors.toList());
	}
	
	private static UserDto toUserDto(UserEntity user) {
		return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
	}
}
