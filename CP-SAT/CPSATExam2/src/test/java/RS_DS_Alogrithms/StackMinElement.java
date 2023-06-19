package RS_DS_Alogrithms;
import java.util.Stack;

public class StackMinElement {
	
	static Stack<Integer> mainStack = new Stack();
	static Stack<Integer> temp = new Stack();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		customPush(12);
		customPop();
		customPush(6);
		customPop();
		customPush(20);
		
		customPush(17);
		customPush(3);
		customPop();
		System.out.println(temp.peek() +" is the minimum element on stack");
		
	}


	private static void customPush(int i) {
		// TODO Auto-generated method stub
		
		mainStack.push(i);
		if(temp.isEmpty())
			temp.push(i);
		
		else if(temp.peek()>i)
			temp.push(i);
				
	}
	
	private static void customPop() {
		int item =mainStack.peek();
		mainStack.pop();
		if(temp.peek() ==item)
		{
			temp.pop();
		}
		
		
	}	
}
