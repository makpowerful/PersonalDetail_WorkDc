package NAL_JavaQuestions;

import java.lang.reflect.Field;

public class _26_autoBotProg {

	static {
		
		try {
			Field value;
			value = String.class.getDeclaredField("value");
			value.setAccessible(true);
			value.set("Hello", "World");
		}
			 catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
	}

}
