package multi_threading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

class Notifier{}

public class ThreeThreadsPrintOneByOne extends Thread{
	
	private Printer p;
	Queue<String> q;
	
	
	
	
	ThreeThreadsPrintOneByOne(Printer p, Queue<String> q)
	{
		this.p = p;
		//this.next = next;
		this.q =q;
	}
	
	public void run(){
		while(true)
		{
			if(!p.print(q))
				break;
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		Queue<String> q=new LinkedList<String>();
		
		Printer p = new Printer();
		ThreeThreadsPrintOneByOne first = new ThreeThreadsPrintOneByOne(p, q);
		first.setName("first");
		ThreeThreadsPrintOneByOne second = new ThreeThreadsPrintOneByOne(p,q);
		second.setName("second");
		ThreeThreadsPrintOneByOne third = new ThreeThreadsPrintOneByOne(p,q);
		third.setName("third");
		
		q.add(first.getName());
		q.add(second.getName());
		q.add(third.getName());
		
		first.start();
		second.start();
		third.start();

	}

}

class Printer{
	ReentrantLock lock = new ReentrantLock(true);
	int i=0;
	 
	public synchronized boolean print(Queue<String> q){
		
		if(i>=100)
			return false;
		
		
		if(q.peek().equals(Thread.currentThread().getName()))
		{
			lock.lock();
			System.out.println(Thread.currentThread().getName()+" prints- "+ ++i);
			lock.unlock();
			
			q.add(q.remove());
		}
		
		return true;
	}
}
