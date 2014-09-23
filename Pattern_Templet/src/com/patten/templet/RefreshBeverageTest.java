package com.patten.templet;

public class RefreshBeverageTest {
	public static void main(String[] args) {
		System.out.println("Preparing Coffee....");
		RefreshBeverage b1 = new Coffee();
		b1.prepareBeverageTemplet();
		System.out.println("Coffee is ready.");
	}
}
