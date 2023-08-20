package org.sekhar.singleton.staticinner;

public class SingletonStaticInner {

	private SingletonStaticInner() {
	}

	private static class SingletonHolder {
		private static final SingletonStaticInner INSTANCE = new SingletonStaticInner();
	}

	public static SingletonStaticInner getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
