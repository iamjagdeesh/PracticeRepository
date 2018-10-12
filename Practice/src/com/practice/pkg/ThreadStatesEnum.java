package com.practice.pkg;

import java.io.Closeable;
import java.io.IOException;

public enum ThreadStatesEnum implements Closeable {
	
	START(1) {
		
		@Override
		public String toString(){
			return "START threadstate : " + getPriority();
		}

		@Override
		public String getDetail() {
			return "START";
		}
		
	},
	RUNNING(2) {

		@Override
		public String getDetail() {
			return "RUNNING";
		}
		
	}
	;
	
	private ThreadStatesEnum(int i) {
		this.priority = i;
	}
	
	private int priority;
	
	public abstract String getDetail();
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		return "Default threadstate : " + getPriority();
	}
	
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Closing Enum!");
	}

}
