package com.jd.learn.concurrent.test1;

import static org.junit.Assert.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class TestConcurrency {
	public static AtomicInteger atom = new AtomicInteger(20);

	public static void main(String[] args) {
//		Mythread my = new Mythread(atom);
//		new Thread(my).start();
//		new Thread(my).start();
		atom.addAndGet(2);
		System.out.println(atom.get());
		atom.decrementAndGet();
		System.out.println(atom.get());
		System.out.println(atom.getAndAdd(2));
		System.out.println(atom.get());
		System.out.println(atom.incrementAndGet());
		System.out.println(atom.decrementAndGet());
		atom.incrementAndGet();
		atom.decrementAndGet();
		atom.addAndGet(2);
	}

	@Test
	public void testAll() throws InterruptedException {
		final AtomicInteger value = new AtomicInteger(10);
		assertEquals(value.compareAndSet(1, 2), false);//true
		assertEquals(value.get(), 10);//true
		assertTrue(value.compareAndSet(10, 3));//true
		assertEquals(value.get(), 3);//true
		value.set(0);
		//
		assertEquals(value.incrementAndGet(), 1);
		assertEquals(value.getAndAdd(2), 1);
		assertEquals(value.getAndSet(5), 3);
		assertEquals(value.get(), 5);
		//
		final int threadSize = 10;
		Thread[] ts = new Thread[threadSize];
		for (int i = 0; i < threadSize; i++) {
			ts[i] = new Thread() {
				public void run() {
					value.incrementAndGet();
				}
			};
		}
		//
		for (Thread t : ts) {
			t.start();
		}
		for (Thread t : ts) {
			t.join();
		}
		//
		assertEquals(value.get(), 5 + threadSize);
	}
}

class Mythread implements Runnable {
	private AtomicInteger at;

	public Mythread(AtomicInteger at) {
		this.at = at;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "---"
				+ at.compareAndSet(20, at.get() + 2) + "   " + at.get());
	}
}
