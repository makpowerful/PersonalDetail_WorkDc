package RS_DS_Alogrithms;
import java.util.LinkedList;

public class DoublyLinkedListJavaMethods {
//StringBuffer reverse
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> l = new LinkedList<String>();
		l.add("Rahul");
		l.add("shetty");
		l.add("hello");
		
		l.addLast("thisLastOne");
		l.addFirst("FirstNode");
		l.add(2, "Middle");
	
		System.out.println(l.contains("hello"));
		l.removeFirst();
		l.removeLast();
		l.remove(3);
		System.out.println(l);
		
		
		
		
		
		
	}

}
