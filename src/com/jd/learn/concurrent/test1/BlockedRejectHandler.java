package com.jd.learn.concurrent.test1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BlockedRejectHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		/*
		 * ThreadPoolExecutor 有四种状态，分别为 RUNNING， SHUTDOWN， STOP， TERMINATED
		 * 只有当线程状态为 RUNNING 时，才能执行并接受新任务，当线程池处 于关闭状态时，不应该再执行新的任务
		 */
		if (processNewTaskLater(executor)) {
			return;
		}
		BlockingQueue<Runnable> queue = executor.getQueue();
		try {
			queue.put(r);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	private boolean processNewTaskLater(ThreadPoolExecutor executor) {
		if (executor.isShutdown()) {
			return false;
		}
		if (executor.isTerminated()) {
			return false;
		}
		if (executor.isTerminating()) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(5,Executors.defaultThreadFactory());
		final Random random = new Random();
		Runnable task = new Runnable(){

			@Override
			public void run() {
				long a = System.currentTimeMillis();
				if(a%2==0){
					try {
						TimeUnit.SECONDS.sleep(1+random.nextInt(5));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		for(int i=0;i<50;i++){
			threadPool.execute(task);
		}
		while(true){
			System.out.println(threadPool.isShutdown());
			System.out.println(threadPool.isTerminated());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(threadPool.isShutdown()){
				System.out.println("it's shut down");
				break;
			}
		}
	}

}
