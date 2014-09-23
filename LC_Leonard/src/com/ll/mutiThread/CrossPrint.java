package com.ll.mutiThread;

/*
 * write two threads. one thread printing numbers12345..., one thread printing characters ABCDE...
 make sure they print in the order  
 12A34B...
 */

public class CrossPrint {
	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();

		Thread t1 = new Thread(new runNumber(obj));
		Thread t2 = new Thread(new runLetter(obj));
		t1.start();
		Thread.sleep(100);
		t2.start();
	}
}

class runNumber implements Runnable {
	private Object obj;
	int x = 53;

	public runNumber(Object obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (obj) {
			for (int i = 1; i < x; i++) {
				System.out.print(i);
				if (i % 2 == 0) {
					obj.notifyAll();
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

}

class runLetter implements Runnable {
	private Object obj;
	int letter = 'A';

	public runLetter(Object obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (obj) {
			for (int i = 0; i < 26; i++) {
				System.out.print((char) (i + letter) + "");
				obj.notifyAll();
				if (i != 25) {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}

	}

}