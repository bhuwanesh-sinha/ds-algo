package multi_threading;

public class WaitNotify {

	public static void main(String[] args) throws InterruptedException {
		MyThread t = new MyThread();
		t.start();
		
		synchronized(t)
		{
			System.out.println("Main got the lock and waiting on t..");
			t.wait();
			System.out.println("Main got notified..");
			System.out.println(t.sum);
		}
	}

}

class MyThread extends Thread{
	int sum=0;
	public void run(){
		
		synchronized(this)
		{
			System.out.println("Child got lock and starts processing..");
			for(int i=0; i<5; i++ )
			{
				sum=sum+1;
				System.out.println(sum);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
		System.out.println("Child notifying main..");
		this.notify();
		}
	}
}


