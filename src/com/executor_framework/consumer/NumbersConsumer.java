package com.executor_framework.consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class NumbersConsumer {

	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(2);
		ExecutorService executor = Executors.newFixedThreadPool(2);

		Runnable consumerTask = () -> {
			try {
				while (true) {

					int value = blockingQueue.take();

					System.out.println("Consumed -> " + value);

					Thread.sleep(1000);
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		executor.execute(consumerTask);
		executor.shutdown();
	}
}