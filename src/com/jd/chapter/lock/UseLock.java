package com.jd.chapter.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseLock {
	public int counter = 0 ;
	public final Lock lock = new ReentrantLock();
	public class Counter implements Runnable{
		@Override
		public void run() {
			lock.lock();
			try {
				TimeUnit.MICROSECONDS.sleep(100l);
				counter++;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		UseLock use = new UseLock();
		Counter count = use.new Counter();
		for(int i=0;i<200;i++){
			new Thread(count).start();
		}
//		try {
//			Thread.currentThread().sleep(1000l);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		System.out.println(use.counter);
	}

	
}
