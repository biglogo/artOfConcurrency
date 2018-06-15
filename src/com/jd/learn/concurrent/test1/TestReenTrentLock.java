package com.jd.learn.concurrent.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class TestReenTrentLock {
	public final ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		TestReenTrentLock test = new TestReenTrentLock();
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		MyThread task = test.new  MyThread();
		for(int i=0;i<20;i++){
			threadPool.execute(task);
		}
	}
	
	
	class MyThread implements Runnable{
		int count=100;

		@Override
		public void run() {
			lock.lock(); // block until condition holds
			try {
				System.out.println(Thread.currentThread().getName() + " get lock");
				System.out.println(Thread.currentThread().getName() + " is consuming count="+count--);
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} finally {
				System.out.println(Thread.currentThread().getName()
						+ " release lock");
				lock.unlock();
				System.out.println();
			}
		}
	}
}

