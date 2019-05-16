package example03CustomAnnotation;

import java.lang.annotation.Annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyArroundAspect{

  @Around("@annotation(MyAnnotation)")
  public Object  myAspectFunc (ProceedingJoinPoint jointPoint) throws Throwable {
    System.out.println("MyArroundAspect in." );

    System.out.println("Joint point = " + jointPoint + " on " + jointPoint.getTarget());
    return jointPoint.proceed();
  }
    
}
