package com.jd.learn.concurrent.test1;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomaic {
	public static AtomicInteger atom = new AtomicInteger(20);
	public static void main(String[] args) {
		TestAtomaic test = new TestAtomaic();
		test.testAdd();
		test.testCAS();
		System.out.println(atom.get());
	}
	
	public void testAdd(){
		System.out.println(atom.addAndGet(2));
	}
	
	public void testCAS(){
		atom.compareAndSet(22, 10);
	}
}
