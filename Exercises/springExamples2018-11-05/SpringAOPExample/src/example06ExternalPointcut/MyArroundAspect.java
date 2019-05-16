package example06ExternalPointcut;

import java.lang.annotation.Annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyArroundAspect{

   @Pointcut ("execution(void example06ExternalPointcut.MyBean.*(int))" )    // pointcut designator
   private void myEmptyVoidMethod(){}                      // Empty void method

  @Around("myEmptyVoidMethod()")
  public Object  myAspectFunc (ProceedingJoinPoint jointPoint) throws Throwable {
    System.out.println("MyArroundAspect1 in. (Logging)" );

    System.out.println("Joint point = " + jointPoint + " on " + jointPoint.getTarget());
    return jointPoint.proceed();
  }

  @Around("myEmptyVoidMethod()")
  public Object  myOtherAspectFunc (ProceedingJoinPoint jointPoint) throws Throwable {
    System.out.println("MyArroundAspect2 in.  (Security)" );

    System.out.println("Joint point = " + jointPoint + " on " + jointPoint.getTarget());
    return jointPoint.proceed();
  }
  
}
