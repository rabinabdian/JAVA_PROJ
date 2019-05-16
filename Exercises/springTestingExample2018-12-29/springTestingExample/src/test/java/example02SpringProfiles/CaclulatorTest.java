package example02SpringProfiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;




@Configuration
 class CalculatorTestConfiguration {
    @Bean
    @Primary
    public IDB createFakeDB() {
        return Mockito.mock(IDB.class);
    }

}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,classes={CalculatorTestConfiguration.class,Example.class})
public class CaclulatorTest {

	@Autowired Calculator calc;
	
	@Autowired IDB fakeDB;

	@Test
	public void testCalculate() {
		calc.calculate(5, 3);
		Mockito.verify(fakeDB).saveValue(36);
	}

}
