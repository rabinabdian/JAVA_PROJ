package example05ClassLevelAndOrder;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class AspectC {

	@Around("@target(myAnnotation)")
	public Object process(ProceedingJoinPoint jointPoint, MyAnnotation myAnnotation) throws Throwable {
		System.out.println(
				"AspectC (Security): myAnnotation target:" + jointPoint.getTarget().getClass().getSimpleName());
		System.out.println(" condition:" + myAnnotation.condition());
		System.out.println(" key:" + myAnnotation.key());
		System.out.println(" value:" + myAnnotation.value());
		return jointPoint.proceed();
	}
}
