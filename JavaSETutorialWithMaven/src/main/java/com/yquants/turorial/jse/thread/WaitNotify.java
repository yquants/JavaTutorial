package com.yquants.turorial.jse.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * This simple class is used to test:
 * 1. wait() & notifyAll();
 * 2. Optional() in Java8
 * 3. LAMBDA Expression in Java 8
 * 
 * @Date: 1/29/2016
 * @author Wei Song
 *
 */
public class WaitNotify {

	public static void main(String[] args) {
		final Random random = new Random(47);
		Runnable consummer = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						TimeUnit.SECONDS.sleep(random.nextInt(10) + 1);
					} catch (Exception e) {

					}
					System.out.println(Thread.currentThread().getName() + "--start");
					Optional<List<?>> optional = Optional.of(Repository.INSTANCE.get());
					optional.ifPresent((value) -> {
						for(Object obj: value)
							System.out.println(obj);
					});
				}
			}
		};

		Runnable producer = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						TimeUnit.SECONDS.sleep(random.nextInt(10) + 10);
					} catch (Exception e) {

					}
					System.out.println(Thread.currentThread().getName() + "--start");
					Repository.INSTANCE.set("1111");
				}
			}
		};

		ExecutorService services = Executors.newCachedThreadPool();
		services.submit(consummer);
		services.submit(consummer);
		services.submit(producer);
		services.shutdown();
	}

	public static class Repository {

		public final static Repository INSTANCE = new Repository();

		private List<String> list = new ArrayList<String>();

		private Repository() {
		}

		public synchronized List<String> get() {
			System.out.println(Thread.currentThread().getName() + "--enter get");
			Optional<List<String>> optional = Optional.of(list);
			if (optional.isPresent())
				if (optional.get().isEmpty())
					try {
						System.out.println(Thread.currentThread().getName() + "--before wait");
						wait();
						System.out.println(Thread.currentThread().getName() + "--after wait");
					} catch (Exception e) {
						e.printStackTrace();
					}
			System.out.println(Thread.currentThread().getName() + "--exit get");
			return list;
		}

		public synchronized void set(String str) {
			System.out.println(Thread.currentThread().getName() + "--enter set");
			Optional<List<String>> optional = Optional.of(list);
			optional.ifPresent((value) -> value.add(str));
			System.out.println(Thread.currentThread().getName() + "--notifyAll");
			notifyAll();
			System.out.println(Thread.currentThread().getName() + "--exit set");
		}
	}

}
