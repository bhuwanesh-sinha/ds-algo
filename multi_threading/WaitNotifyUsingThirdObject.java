package multi_threading;

public class WaitNotifyUsingThirdObject {



	public static void main(String[] args) throws InterruptedException {
		Obj o = new Obj();
		MyThread1 t = new MyThread1(o);
		t.start();
		//if child gets the lock first then main will keep on waiting indefinitely..
		//Thread.sleep(1000);
		synchronized(o)
		{
			System.out.println("Main got the lock and waiting on t..");
			o.wait();
			System.out.println("Main got notified..");
			System.out.println(t.sum);
		}
	}



}

class MyThread1 extends Thread{
	int sum=0;
	Obj o;
	MyThread1(Obj o)
	{
		this.o = o;
	}
	public void run(){
		
		synchronized(o)
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
		o.notify();
		}
	}
}

class Obj{}
