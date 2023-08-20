package org.sekhar.singleton.staticinner;

public class SingletonStaticInnerMain {
	public static void main(String[] args) {
		SingletonStaticInner singleton = SingletonStaticInner.getInstance();
		System.out.println(singleton.hashCode());

		singleton = SingletonStaticInner.getInstance();

		System.out.println(singleton.hashCode());

	}
}
