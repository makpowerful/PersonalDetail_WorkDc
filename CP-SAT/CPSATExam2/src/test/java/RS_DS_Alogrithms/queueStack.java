package RS_DS_Alogrithms;
import java.util.Stack;

public class queueStack {

	static Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	public void Enqueue(int x)
	{
		stack1.push(x);
	}
	
	public int Dequeue()
	{
		
		while(!stack1.isEmpty())
		{
			stack2.push(stack1.pop());
		}
		int ele =stack2.pop();
		
		while(!stack2.isEmpty())
		{
			stack1.push(stack2.pop());
		}
		return ele;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queueStack queue = new queueStack();
		queue.Enqueue(4);
		queue.Enqueue(5);
		queue.Enqueue(7);
		queue.Dequeue();
		queue.Enqueue(12);
		queue.Enqueue(14);
		queue.Dequeue();
		
		System.out.println(stack1);
		
	
		
		
		
	}

}
