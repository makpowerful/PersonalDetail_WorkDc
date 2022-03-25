package dockertesting.dockerValidtn;

import java.util.stream.Stream;

import org.testng.annotations.Test;


public class TestSample1 {

	@Test
	public void test_Stream() {
		
		Long c=Stream.of("Kalam","King","Albert").filter(s->s.startsWith("K")).count();
		System.out.println(c);
		Stream.of("Kalam","King","Albert").filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		Stream.of(1,2,2,34,8).distinct().sorted().forEach(s->System.out.println(s));
		
	}
}
