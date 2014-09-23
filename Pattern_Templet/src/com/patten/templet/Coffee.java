package com.patten.templet;

/*
 *   Concrete class of implementing coffee
 */
public class Coffee extends RefreshBeverage{

	@Override
	protected void brew() {
		// TODO Auto-generated method stub
		System.out.println("brew coffee");
		
	}

	@Override
	protected void addCondiiments() {
		// TODO Auto-generated method stub
		System.out.println("add milk and sugar");
		
	}

}
