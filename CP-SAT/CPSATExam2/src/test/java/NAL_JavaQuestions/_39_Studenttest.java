package NAL_JavaQuestions;
import java.util.*;
public class _39_Studenttest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		_39_StudentPO s1 = new _39_StudentPO("Malcom", 0001, 10, 50);
		_39_StudentPO s2 = new _39_StudentPO("Richard", 0002, 12, 80);
		_39_StudentPO s3 = new _39_StudentPO("Demin", 0003, 14, 100);
		_39_StudentPO s4 = new _39_StudentPO("Alex", 0004, 16, 30);
		_39_StudentPO s5 = new _39_StudentPO("Sintaur", 0005, 8, 45);
		
		//Adding using List
		List<_39_StudentPO> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		
		for(_39_StudentPO e : list) {
			System.out.println(e);
		}
		
		System.out.println("****************************");
		
		list.stream().forEach(e -> System.out.println(e));
		
		System.out.println("****************************");
		
		//With marks greater than 70
		
		list.stream().filter(e -> e.getMarks()>70).forEach(e -> System.out.println(e.getName()+" : "+e.getMarks() ));
	}

}
