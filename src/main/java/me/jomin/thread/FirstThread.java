package me.jomin.thread;

/**
 * 一般采用实现Runnable、Callable接口来实现多线程
 * 好处：
 * 	-多个线程可以共享一个target，非常适合多个线程同时来处理同一份资源的情况
 * 	-编程稍复杂，要用Thread.currentThread()才能获取当前线程
 * @author YANGMING663
 * 2013年12月6日
 */
public class FirstThread extends Thread {

	//i变量在多个线程间不能共享
	private int i;
	
	@Override
	public void run() {
		for(; i<100;i++) {
			//可以用this获取当前线程
			System.out.println(getName() + " " + i);
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i == 20) {
				new FirstThread().start();
				new FirstThread().start();
			}
			
		}
	}
}
