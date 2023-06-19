package RS_DS_Alogrithms;
import java.util.Stack;

public class StackDS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();
		
		System.out.println(stack1.empty());
		stack1.push(34);
		stack1.push(3);
		stack1.push(31);
		stack1.push(98);
		stack1.push(14);
		System.out.println(stack1);
		moveStack(stack1,stack2);
		moveStack(stack2,stack3);
		moveStack(stack3,stack1);
		System.out.println(stack1);
		
		
//		stack1.pop(); //LIFO
//		System.out.println(stack1);
//		int peekedValue = stack1.peek();
//		System.out.println(peekedValue);
//		System.out.println(stack1);
//		System.out.println(stack1.contains(31));
//		stack1.insertElementAt(100, 2);
//		System.out.println(stack1);
//		stack1.remove(0);
		
		
	}

	private static void moveStack(Stack<Integer> source, Stack<Integer> dest) {
		
		while(!source.empty())
		{
		int item = source.peek();
		dest.push(item);
		source.pop();
		}
		
	}

}
