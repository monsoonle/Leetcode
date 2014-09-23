package com.patten.templet;

/*
 * Given a templet about refresh beverage
 */

public abstract class RefreshBeverage {

	/*
	 * templet method that encapsulates the steps of making a beverage
	 */
	public final void prepareBeverageTemplet() {
		boilWater();
		brew();
		pourIntoCup();
		addCondiiments();

	}

	private void boilWater() {
		// common action
		System.out.println("Boil water");
	}

	private void pourIntoCup() {
		
		System.out.println("Pour beverage into cup");

	}

	//Implementation will be given with subclass
	protected abstract void brew();

	protected abstract void addCondiiments();

}
