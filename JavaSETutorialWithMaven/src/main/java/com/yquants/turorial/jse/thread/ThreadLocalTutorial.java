package com.yquants.turorial.jse.thread;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class ThreadLocalTutorial {

	/*
	 * The same Runnable instance has been invoked 5 times in 5 different
	 * Threads. This is to demonstrate that ThreadLocal is threadsafe that each
	 * thread will keep a copy of the instance. Sample Output: pool-1-thread-2
	 * start with value: 1 pool-1-thread-4 start with value: 1 pool-1-thread-1
	 * start with value: 1 pool-1-thread-3 start with value: 1 pool-1-thread-5
	 * start with value: 1 pool-1-thread-2 ends with value: 2 pool-1-thread-5
	 * ends with value: 2 pool-1-thread-4 ends with value: 2 pool-1-thread-3
	 * ends with value: 2 pool-1-thread-1 ends with value: 2
	 */
	@Test
	public static void testThreadLocal() {
		ExecutorService service = Executors.newCachedThreadPool();

		Runnable task = new Runnable() {
			ThreadLocal<AtomicInteger> tlocal = new ThreadLocal<AtomicInteger>() {
				@Override
				public AtomicInteger initialValue() {
					return new AtomicInteger(1);
				}
			};

			public void run() {
				System.out.println(Thread.currentThread().getName() + " start with value: " + tlocal.get());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				tlocal.set(new AtomicInteger(tlocal.get().addAndGet(1)));
				System.out.println(Thread.currentThread().getName() + " ends with value: " + tlocal.get());
			}
		};
		for (int i = 0; i < 5; i++)
			service.submit(task);
		service.shutdown();
	}

	/*
	 * 
	 * pool-2-thread-1 start with value: 1 pool-2-thread-2 start with value: 1
	 * pool-2-thread-4 start with value: 1 pool-2-thread-3 start with value: 1
	 * pool-2-thread-5 start with value: 1 pool-2-thread-3 ends with value: 2
	 * pool-2-thread-1 ends with value: 3 pool-2-thread-2 ends with value: 4
	 * pool-2-thread-5 ends with value: 6 pool-2-thread-4 ends with value: 6
	 */
	@Test
	public static void testNonThreadLocal() {
		ExecutorService service = Executors.newCachedThreadPool();

		Runnable task = new Runnable() {
			NonThreadLocal<AtomicInteger> tlocal = new NonThreadLocal<AtomicInteger>() {
				@Override
				public AtomicInteger initialValue() {
					return new AtomicInteger(1);
				}
			};

			public void run() {
				System.out.println(Thread.currentThread().getName() + " start with value: " + tlocal.get());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				int res;
//				synchronized ("ABC") {
					res = tlocal.get().addAndGet(1);
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
					tlocal.set(new AtomicInteger(res));
//				}
				System.out.println(Thread.currentThread().getName() + " ends with value: " + res);
			}
		};
		for (int i = 0; i < 5; i++)
			service.submit(task);
		service.shutdown();

	}

	private static class NonThreadLocal<T> {
		private T t;
		boolean initialized = false;

		protected T initialValue() {
			return null;
		}

		public synchronized T get() {
			if (t == null && !initialized)
				t = initialValue();
			return t;
		}

		public synchronized void set(T t) {
			this.t = t;
		}
	}

	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = ThreadLocalTutorial.class.getMethods();
		final Object[] param = null;
		for (Method m : methods) {
			if (m.isAnnotationPresent(Test.class))
				m.invoke(null, param);
		}
	}
}
