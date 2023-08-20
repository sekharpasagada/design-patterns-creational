package org.sekhar.singleton.simple;

public class Sandbox {
	public static void main(String[] args) {

		Singleton singleton = Singleton.getSingletonInstance();
		singleton.setDetails("Test1");
		
		System.out.println(singleton.getDetails());
		
		Singleton singleton1 = Singleton.getSingletonInstance();
		singleton1.setDetails("Test2");
		System.out.println(singleton1.getDetails());
		System.out.println(singleton.getDetails());
		
		
		
	       EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE.getInstance();
	        
	        System.out.println(enumSingleton1.getInfo()); //Initial enum info
	        
	        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE.getInstance();
	        enumSingleton2.setInfo("New enum info");
	        
	        System.out.println(enumSingleton1.getInfo()); //New enum info
	        System.out.println(enumSingleton2.getInfo()); //New enum info
	}
}
