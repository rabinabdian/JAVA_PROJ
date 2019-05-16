package example01MockitoInjectMocks;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class CaclulatorTest {

	@Mock IDB fakeDB;
	@InjectMocks Calculator calc;
	
	@Test
	public void testCalculate() {
		MockitoAnnotations.initMocks(this);
		calc.calculate(5, 3);
		Mockito.verify(fakeDB).saveValue(36);
	}

}
