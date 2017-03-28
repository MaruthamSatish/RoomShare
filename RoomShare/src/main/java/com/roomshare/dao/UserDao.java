package com.roomshare.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.roomshare.model.User;
@Transactional
public interface UserDao extends CrudRepository<User, Long> {

}
