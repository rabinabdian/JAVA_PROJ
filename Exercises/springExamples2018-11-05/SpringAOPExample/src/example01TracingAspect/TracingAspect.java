package example01TracingAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {
	
    @Around("execution(* example01TracingAspect.TestClass.*(..))")
    public Object trace(ProceedingJoinPoint pjp) throws Throwable {
	String methodName = pjp.getSignature().getName();
	System.out.println("Entering: " + methodName);
	try {
	    return pjp.proceed();
	} finally {
	    System.out.println("Exiting: " + methodName);
	}
    }
}
