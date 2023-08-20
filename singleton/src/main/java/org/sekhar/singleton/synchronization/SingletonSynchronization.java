package org.sekhar.singleton.synchronization;

public class SingletonSynchronization {

	private static SingletonSynchronization INSTANCE;

	private SingletonSynchronization() {

	}

	public static synchronized SingletonSynchronization getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonSynchronization();
		}
		return INSTANCE;
	}

}
