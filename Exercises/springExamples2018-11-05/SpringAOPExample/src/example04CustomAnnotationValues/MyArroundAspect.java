package example04CustomAnnotationValues;

import java.lang.annotation.Annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyArroundAspect{

   @Around("execution(@example04CustomAnnotationValues.MyAnnotation * *(..)) &&@annotation(myAnnotation)")
  public Object process(ProceedingJoinPoint jointPoint, MyAnnotation myAnnotation)   throws Throwable {
	  System.out.println("MyArroundAspect-2: myAnnotation:" + jointPoint.getTarget().getClass().getSimpleName() );
	  System.out.println("MyArroundAspect-2: myAnnotation condition:" + myAnnotation.condition());
	  System.out.println("MyArroundAspect-2: myAnnotation key:" + myAnnotation.key());
	  System.out.println("MyArroundAspect-2: myAnnotation value:" + myAnnotation.value());
	  return jointPoint.proceed();
  }

}
