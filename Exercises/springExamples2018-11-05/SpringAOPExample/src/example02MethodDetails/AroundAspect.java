package example02MethodDetails;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect {
@Around("execution(java.lang.Integer example02MethodDetails.MyBean.*(..)) &&  args(java.lang.Integer)")

	public void checkAroundSetter(final ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("AroundAspect befor:" + pjp.getSignature().toLongString());
		Object[] args = pjp.getArgs();
		printAndChange(args);
		Object targetMethodResult = pjp.proceed(args);
		System.out.println("AroundAspect - AFTER - targetMethodResult:" + targetMethodResult);
		print(args);
	}

	private void print(Object[] args) {
		Arrays.stream(args).forEach(a -> {
			System.out.println("AroundAspect AFTER arg:" + a);
		});
	}

	private void printAndChange(Object[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("AroundAspect BEFORE - args[" + i + "]:" + args[i] + " changing to 99..");
			if (args[i] instanceof Integer) {
				args[i] = new Integer(99); // CHANGE THE VALUE
			}
		} /* for */
	}/* method */
} /* class */
