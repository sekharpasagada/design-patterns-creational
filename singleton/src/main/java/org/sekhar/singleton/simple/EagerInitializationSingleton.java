package org.sekhar.singleton.simple;

public class EagerInitializationSingleton {

	private static final	EagerInitializationSingleton INSTANCE = new EagerInitializationSingleton();
	
	public static EagerInitializationSingleton getInstance() {
		
		return INSTANCE;
	}
	
}
