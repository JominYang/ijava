package me.jomin.thread;
/*
 * 控制线程
 * 	|-join线程 让一个线程等待另一个线程完成的方法
 * 	|-setDeamon后台线程
 * 	|-sleep线程睡眠 进入阻塞状态
 * 	|-yield线程让步 进入就绪状态
 * 	|-setPriority设置线程优先级
 */
public class SecondThread implements Runnable {

	private int i;
	//run()是线程执行体
	public void run() {
		for(; i < 100; i++) {
			//实现Runnable接口时，只能用Thread.currentThread()方法获取当前线程
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if( i == 20 ) {
				SecondThread st = new SecondThread();
				new Thread(st, "新线程1").start();
				new Thread(st, "新线程2").start();
			}
		}
	}

}
