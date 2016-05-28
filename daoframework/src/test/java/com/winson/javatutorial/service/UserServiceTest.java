package com.winson.javatutorial.service;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.winson.javatutorial.vo.User;

public class UserServiceTest {

	@Test
	public void testAddMore() {
		ExecutorService service = Executors.newCachedThreadPool();

		Runnable task = new Runnable() {

			public void run() {
				final int max = new Random().nextInt(20);
				System.out.println("max:" + max);
				User[] users = new User[max];
				for (int j = 0; j < max; j++)
					users[j] = new User();
				new UserService().addUser(users);
			}
		};

		for (int i = 0; i < 20; i++){
			System.out.println("Thread:" + i);
			service.submit(task);
		}
		service.shutdown();
	}
}
