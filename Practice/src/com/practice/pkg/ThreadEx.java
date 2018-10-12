package com.practice.pkg;

public class ThreadEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable runnable = () -> {
			System.out.println("Inside run method of thread: " + Thread.currentThread().getName());
		};
		Thread t1 = new Thread(runnable, "t1");
		Thread t2 = new Thread(runnable, "t2");
		System.out.println("Starting Runnable threads");
        t1.start();
        t2.start();
        System.out.println("Runnable Threads has been started");
        Thread t3 = new ExtendingThreadClass("t3");
        Thread t4 = new ExtendingThreadClass("t4");
        System.out.println("Starting Thread class's threads");
        t3.start();
        t4.start();
        System.out.println("Runnable Threads has been started");
	}

}
