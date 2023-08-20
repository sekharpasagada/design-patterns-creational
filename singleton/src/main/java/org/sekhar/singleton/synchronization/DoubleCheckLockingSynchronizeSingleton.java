package org.sekhar.singleton.synchronization;

public class DoubleCheckLockingSynchronizeSingleton {

	private static DoubleCheckLockingSynchronizeSingleton INSTANCE;

	private DoubleCheckLockingSynchronizeSingleton() {
	}

	public static DoubleCheckLockingSynchronizeSingleton getInstance() {

		if (INSTANCE == null) {

			synchronized (DoubleCheckLockingSynchronizeSingleton.class) {

				if (INSTANCE == null) {
					INSTANCE = new DoubleCheckLockingSynchronizeSingleton();
				}

			}

		}
		return INSTANCE;
	}
}
