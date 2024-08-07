package sn.zone01dakar.security.dao;

import java.util.Optional;

import sn.zone01dakar.security.entity.UserEntity;

public interface IUserDao extends Repository<UserEntity> {
	
	public Optional<UserEntity> login(String email, String password);

}
