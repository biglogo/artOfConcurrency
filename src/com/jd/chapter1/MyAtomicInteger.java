package com.jd.chapter1;

public class MyAtomicInteger {
	public volatile int value;
	
	public int addAndGet(){
		
	}
	
	public int GetAndAdd(){
		
	}
	
	public int IncrementAndGet(){
		for(;;){
			if(get()==this.value){
				this.value= this.value+1;
			}
		}
	}
	
	public boolean compareAndSet(int expect,int value){
		for(;;){
			if(get()==expect){
				this.value= value;
			}
		}
	}
	
	public int get(){
		
	}
}
