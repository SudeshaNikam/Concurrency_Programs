package com.executor_framework.producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class NumbersProducer implements Runnable {
	private String name;
	static final int MAX_THREAD = 2;

	public NumbersProducer(String s) {
		name = s;
	}

	public void run() {
		try {
			for (int i = 0; i <= 3; i++) {
				System.out.println("Produced ->" + i);
				Thread.sleep(1000);
			}
			System.out.println(name + " complete");
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Runnable r1 = new NumbersProducer("task 1");
		Runnable r2 = new NumbersProducer("task 2");
		Runnable r3 = new NumbersProducer("task 3");
		Runnable r4 = new NumbersProducer("task 4");
		Runnable r5 = new NumbersProducer("task 5");

		ExecutorService pool = Executors.newFixedThreadPool(MAX_THREAD);

		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);

		pool.shutdown();
	}
}
