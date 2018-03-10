package org.denny.bean.annotation.repository.impl;

import org.denny.bean.annotation.BaseObject;
import org.denny.bean.annotation.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserRepositoryImpl extends BaseObject implements UserRepository {

	@Override
	public void save(Object obj) {
		System.out.println("UserRepositoryImpl....");
		System.out.println(obj);
	}

}
