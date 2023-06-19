package RS_DS_Alogrithms;

public class queuedemo {
	//
	int rear;
	int front;
	int[] a;
	int size;
	
	
	
	public queuedemo(int size)
	{
		rear = -1;
		this.size=size;
		//front = 0;
	this.a = new int[size];
	}
	
	public void enQueue(int x)
	{
			rear++;
			a[rear]= x;
			
		
	}
	
	public int deQueue()
	{
		
		int ele =a[0];
		for(int i =0;i<rear;i++)
		{
			a[i] = a[i+1];
			
		}
		rear--;
		return ele;
	}
	
	public void printQueue()
	{
		for(int i =0;i<=rear;i++)
		{
			System.out.println(a[i]);
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		queuedemo qd = new queuedemo(5);
		qd.enQueue(4);
		qd.enQueue(2);
		qd.deQueue();
		qd.enQueue(9);
		qd.enQueue(3);
		qd.enQueue(12);
		qd.deQueue();
		qd.deQueue();
		
		qd.printQueue();
		
		
		
	
	
		
		
	}

}
