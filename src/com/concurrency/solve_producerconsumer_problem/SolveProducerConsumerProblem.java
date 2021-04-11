package com.concurrency.solve_producerconsumer_problem;

import java.util.LinkedList;

//Solving Producer Consumer Problem using wait and notify method

public class SolveProducerConsumerProblem {
	public static void main(String[] args) throws InterruptedException {
		final ProducerConsumer pc = new ProducerConsumer();

		// Create producer thread
		Thread producerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Create consumer thread
		Thread consumerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		producerThread.start();
		consumerThread.start();

		producerThread.join();
		consumerThread.join();
	}

	public static class ProducerConsumer {
		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 2;

		public void produce() throws InterruptedException {
			int value = 0;
			while (true) {
				synchronized (this) {
					while (list.size() == capacity)
						try {
							System.out.println("Queue is Full, " + Thread.currentThread().getName()
									+ " is waiting Size : " + list.size());
							wait();
						} catch (Exception ex) {
							ex.printStackTrace();
						}

					System.out.println("Produced ->" + value);

					list.add(value++);
					notify();
					Thread.sleep(1000);
				}
			}
		}

		public void consume() throws InterruptedException {
			while (true) {
				synchronized (this) {
					while (list.size() == 0)
						System.out.println("Queue is empty, " + Thread.currentThread().getName() + " is waiting Size : "
								+ list.size());
					try {
						wait();
					} catch (Exception ex) {
						ex.printStackTrace();
					}

					int val = list.removeFirst();
					System.out.println("consumed ->" + val);
					notify();
					Thread.sleep(1000);
				}
			}
		}
	}
}
