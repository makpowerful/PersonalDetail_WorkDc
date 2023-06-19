package RS_DS_Alogrithms;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueInBuilt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<Integer> queue = new PriorityQueue<>();
		
		queue.add(4);
		queue.add(2);
		queue.remove();
		queue.add(9);
		queue.add(3);
		queue.add(12);
		queue.remove();
		queue.remove();
		
		for(int ele : queue)
		{
			System.out.println(ele);
		}
		
		
		
		//2,4,7,3,1
		
		//2,3,4,7,7
		
		//9,12
		
		

	}

}
