package example02MethodDetails;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class AfterReturningAspect {

    @AfterReturning(pointcut="execution(java.lang.Integer *.*(..))", returning = "result")
    public void doAccessCheck(org.aspectj.lang.JoinPoint jp, Object result) {
	System.out.println("AfterReturningAspect ASPECT: " + jp);
	if (result != null) {
	        System.out.println("\t\tAfterReturningAspect Returned value : " +  result.toString());
               } else{
	        System.out.println("\t\tAfterReturningAspect Returned null as return value.");
	        System.out.println("\t\t                     to get results Disable AroundAspect");
               }		
    }
}
