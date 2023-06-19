package RS_DS_Alogrithms;
import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack1 = new Stack<Integer>();
		stack1.push(34);
		stack1.push(3);
		stack1.push(31);
		stack1.push(98);
		stack1.push(14);
		System.out.println(stack1);
		System.out.println(SortStack(stack1));
		
		
		
	}

	private static Stack<Integer> SortStack(Stack<Integer> stack1) {
		// TODO Auto-generated method stub
		
		Stack<Integer> tempstk = new Stack<>();
		
		while(!stack1.isEmpty())
		{
			int temp =stack1.pop();
		
				while(!tempstk.isEmpty() && tempstk.peek()>temp )//adjustment to have least num in bottom
				{
					int tt =tempstk.pop();
					stack1.push(tt);
				}
				tempstk.push(temp);
				
			
			
		}
		
		return tempstk;
	}

}
