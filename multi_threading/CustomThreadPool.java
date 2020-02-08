package multi_threading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CustomThreadPool {
	BlockingQueue queue = new BlockingQueue(10);
	List<CustomThread> threads = new ArrayList<CustomThread>();
	boolean isShutDown=false;
	
	CustomThreadPool(int size)
	{
		for(int i=0; i<size;i++)
		{
			CustomThread thread = new CustomThread(queue, "Thread"+i);
			thread.start();
			threads.add(thread);
			
		}
	}
	
	public void submit(Runnable r) throws InterruptedException{
		if(isShutDown){throw new IllegalStateException("Executor was shutDown..");}
		queue.enqueue(r);
	}
	
	public void shutDown()
	{
		for(CustomThread t : threads)
		{
			t.stopped=true;
		}
		
		isShutDown=true;
	}

	public static void main(String[] args) {
		CustomThreadPool pool = new CustomThreadPool(5);
		int ctr=0;
		try {
			for(int j=0;j<5;j++)
			pool.submit(() -> {for(int i=0;i<5;i++){System.out.println("My number is : "+(ctr+i)); try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception : "+e.getMessage());
		}

	}

}


class CustomThread extends Thread{
	BlockingQueue queue;
	String name;
	
	CustomThread(BlockingQueue queue, String name){this.queue=queue; this.name=name;}
	
	boolean stopped=false;
	public void run()
	{
		while(!stopped)
		{
			try {
				System.out.println("Thread : "+name +"starting job..");
				queue.dequeue().run();
				System.out.println("Thread : "+name +"done job..");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void stopThread()
	{
		stopped=true;
		this.interrupt();
	}
}


class BlockingQueue{
	private Queue<Runnable> queue = new LinkedList<Runnable>();
	int size;
	
	BlockingQueue(int size){this.size=size;}
	
	public  synchronized void enqueue(Runnable r) throws InterruptedException{
		if(queue.size()>=size)
			this.wait();
		queue.add(r);
		this.notifyAll();
	}
	
	public synchronized Runnable dequeue() throws InterruptedException{
		if(queue.isEmpty())
			this.wait();
		
		Runnable r = queue.poll();
		this.notifyAll();
		
		return r;
	}
	
}