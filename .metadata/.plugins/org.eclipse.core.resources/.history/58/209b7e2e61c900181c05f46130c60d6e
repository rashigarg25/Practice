package com.practice.prod.consumer;

import java.util.Queue;

public class Producer implements Runnable {

	private Queue<Integer> ll;

	public Producer(Queue<Integer> ll) {
		this.ll = ll;
	}

	@Override
	public void run() {
		produce();
	}

	private void produce() {
		int counter = 0;
		try {
			while (true) {
				synchronized (ll) {
					if (ll.size() == 5) {
						ll.wait();
					}
					System.out.println("Producing value -> " + counter);
					ll.add(counter);
					counter++;
					// Thread.sleep(500);
					ll.notifyAll();
					if (counter == 10)
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
