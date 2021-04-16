package com.ravi.springdemo;

import java.util.List;

public class Restaurant {

	private List restaruantWaitersList;

	public void setRestaruantWaitersList(List restaruantWaitersList) {
		this.restaruantWaitersList = restaruantWaitersList;
	}

	public void displayWaitersNames() {

		System.out.println("All waiters working in Restaruant  :  " + restaruantWaitersList);
	}

}
