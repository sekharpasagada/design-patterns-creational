package org.sekhar.singleton.synchronization;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Assert;
import org.junit.Test;
import org.sekhar.singleton.simple.EagerInitializationSingleton;
import org.sekhar.singleton.simple.EnumSingleton;
import org.sekhar.singleton.staticinner.SingletonStaticInner;

/**
 * Unit tests for the singleton synchronization package with the same name.
 * 

 *
 */
public class SingletonSynchronizationIntegrationTest {

	/**
	 * Size of the thread pools used.
	 */
	private static final int POOL_SIZE = 1000;
	
	/**
	 * Number of tasks to submit.
	 */
	private static final int TASKS_TO_SUBMIT = 1000000;


	@Test
	public void givenSingletonSynchronization_whenMultithreadInstancesEquals_thenTrue() {
		ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
	final  	Set<SingletonSynchronization> resultSet =   Collections.synchronizedSet(new HashSet<SingletonSynchronization>());   //  Collections.synchronizedSet(new HashSet<>());

		// Submits the instantiation tasks.
		for (int i = 0; i < TASKS_TO_SUBMIT; i++) {
	
			boolean add = resultSet.add(SingletonSynchronization.getInstance());
				executor.submit(() -> resultSet.add(SingletonSynchronization.getInstance()));
		//	executor.submit(() -> resultSet.add(SingletonSynchronization.getInstance()));
		}

		// Since the instance of the object we inserted into the set is always
		// the same, the size should be one.
		Assert.assertEquals(1, resultSet.size());
	}
	
	@Test
	public void givenDclSingleton_whenMultithreadInstancesEquals_thenTrue() {
		ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
		final Set<DoubleCheckLockingSynchronizeSingleton> resultSet = Collections.synchronizedSet(new HashSet<DoubleCheckLockingSynchronizeSingleton>());

		// Submits the instantiation tasks.
		for (int i = 0; i < TASKS_TO_SUBMIT; i++) {
			executor.submit(() -> resultSet.add(DoubleCheckLockingSynchronizeSingleton.getInstance()));
		}

		// Since the instance of the object we inserted into the set is always
		// the same, the size should be one.
		Assert.assertEquals(1, resultSet.size());
	}

	@Test
	public void givenEarlyInitSingleton_whenMultithreadInstancesEquals_thenTrue() {
		ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
		Set<EagerInitializationSingleton> resultSet = Collections.synchronizedSet(new HashSet<>());

		// Submits the instantiation tasks.
		for (int i = 0; i < TASKS_TO_SUBMIT; i++) {
			executor.submit(() -> resultSet.add(EagerInitializationSingleton.getInstance()));
		}

		// Since the instance of the object we inserted into the set is always
		// the same, the size should be one.
		Assert.assertEquals(1, resultSet.size());
	}

	@Test
	public void givenInitOnDemandSingleton_whenMultithreadInstancesEquals_thenTrue() {
		ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
		Set<SingletonStaticInner> resultSet = Collections.synchronizedSet(new HashSet<>());

		// Submits the instantiation tasks.
		for (int i = 0; i < TASKS_TO_SUBMIT; i++) {
			executor.submit(() -> resultSet.add(SingletonStaticInner.getInstance()));
		}

		// Since the instance of the object we inserted into the set is always
		// the same, the size should be one.
		Assert.assertEquals(1, resultSet.size());
	}

	@Test
	public void givenEnumSingleton_whenMultithreadInstancesEquals_thenTrue() {
		ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
		Set<EnumSingleton> resultSet = Collections.synchronizedSet(new HashSet<>());

		// Submits the instantiation tasks.
		for (int i = 0; i < TASKS_TO_SUBMIT; i++) {
			executor.submit(() -> resultSet.add(EnumSingleton.INSTANCE));
		}

		// Since the instance of the object we inserted into the set is always
		// the same, the size should be one.
		Assert.assertEquals(1, resultSet.size());
	}
}