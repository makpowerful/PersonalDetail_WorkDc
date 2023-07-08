package NAL_JavaQuestions;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class _50_randomProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Using Random Method
		Random random = new Random();
		System.out.println("int : "+random.nextInt());
		System.out.println("double : "+random.nextDouble());
		System.out.println("float : "+random.nextFloat());
		System.out.println("boolean : "+random.nextBoolean());
		
		//Setting range
		System.out.println(random.nextInt(20));
		System.out.println(random.nextInt(20));
		System.out.println(random.nextInt(20));
		System.out.println(random.nextInt(20));
		
		System.out.println("*************************");
		
		//Using Math.random
		System.out.println("double : "+Math.random());
		
		//Setting range
		System.out.println((int)(Math.random()*20));
		
		System.out.println("*************************");
		//Using ThreadLocalRandom
		System.out.println("int : "+ThreadLocalRandom.current().nextInt());
		System.out.println("double : "+ThreadLocalRandom.current().nextDouble());
		System.out.println("float : "+ThreadLocalRandom.current().nextFloat());
		System.out.println("boolean : "+ThreadLocalRandom.current().nextBoolean());
		
		//Setting range
		System.out.println(ThreadLocalRandom.current().nextInt(0,20));
		System.out.println(ThreadLocalRandom.current().nextInt(0,20));
		System.out.println(ThreadLocalRandom.current().nextInt(0,20));
		System.out.println(ThreadLocalRandom.current().nextInt(0,20));
	}

}
