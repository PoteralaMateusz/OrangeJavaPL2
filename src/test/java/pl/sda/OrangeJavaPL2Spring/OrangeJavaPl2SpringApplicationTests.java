package pl.sda.OrangeJavaPL2Spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class OrangeJavaPl2SpringApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void bigDecimalTest() {
		BigDecimal bigDecimal = new BigDecimal(19.999999);
		BigDecimal bigDecimal2 = BigDecimal.valueOf(19.999999);

		System.out.println("-------------new-----------------");
		System.out.println(bigDecimal);
		System.out.println("-------------valueOf-----------------");
		System.out.println(bigDecimal2);
	}

	// List / ArrayList - List jest interfacem a ArrayList jest implementacją ArrayList

}
