package com.ll.java;

public class Polymorphism {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		A c = new B();
		a.foo(a);
		a.foo(b);
		a.foo(c);
		c.foo(a);
		c.foo(b);
		c.foo(c);
		b.foo(a);
		b.foo(b);
		b.foo(c);

	}
}

class A {
	public void foo(A a) {
		System.out.println("I am A");
	}
}

class B extends A {
	public void foo(B b) {
		System.out.println("I am B");
	}

}