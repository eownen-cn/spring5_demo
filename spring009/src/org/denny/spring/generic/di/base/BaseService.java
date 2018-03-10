package org.denny.spring.generic.di.base;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
	
	@Autowired
	protected BaseRepository<T> repository ;
	
	public void add() {
		System.out.println("BaseService add ... ");
		System.out.println("Repository : " + repository);
	}
}
