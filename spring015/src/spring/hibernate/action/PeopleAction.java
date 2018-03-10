package spring.hibernate.action;

import spring.hibernate.service.PeopleService;

public class PeopleAction{
	
	private PeopleService peopleService ;
	
	public void setPeopleService(PeopleService peopleService) {
		this.peopleService = peopleService;
	}
	
	public String execute() {
		System.out.println("execute ... ");
		peopleService.save();
		return "success" ;
	}
	
}
