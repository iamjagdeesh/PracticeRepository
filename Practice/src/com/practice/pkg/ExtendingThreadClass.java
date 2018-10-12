package com.practice.pkg;

public class ExtendingThreadClass extends Thread {
	
	public ExtendingThreadClass(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("Thread Class - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            //Get database connection, delete unused data from DB
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Class - END "+Thread.currentThread().getName());
    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
