package me.jomin.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThirdThread implements Callable<Integer> {

	public Integer call() throws Exception {
		
		int i = 0;
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		//不同的是，call方法可以有返回值
		return i;
	}
	
	public static void main(String[] args) {
		ThirdThread tt = new ThirdThread();
		//使用FutureTask来包装Callable对象
		FutureTask<Integer> task = new FutureTask<Integer>(tt);
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i == 20) {
				new Thread(task,"有返回值的线程").start();
			}
		}
		
		//获取子进程的返回值
		try {
			System.out.println("子线程的返回值" + task.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
