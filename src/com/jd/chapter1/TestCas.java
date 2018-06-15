package com.jd.chapter1;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCas {
	private AtomicInteger atomicI = new AtomicInteger(0);
	private int i =0;
	public static void main(String[] args) {
		final Counter cas = new Counter();
	}
}
