package NAL_JavaQuestions;

import java.util.stream.*;

public class _2_printNumbersWithoutLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Print from 1 to 100 without loop
		//add(1);
		IntStream.range(1,101).forEach(e -> System.out.println(e));
	}
	
    public static void add(int a){
        if(a<=100){
            System.out.println(a);
            a++;
            add(a);
        }
    }

}
