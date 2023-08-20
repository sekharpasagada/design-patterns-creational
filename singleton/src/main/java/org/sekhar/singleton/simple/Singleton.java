package org.sekhar.singleton.simple;

public class Singleton {

	private static Singleton Instance; 
	private String details;

	private Singleton() {
		// TODO Auto-generated constructor stub
	}

	public static Singleton getSingletonInstance() {
		if (Instance == null) {
			Instance = new Singleton();
		}
		return Instance;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
