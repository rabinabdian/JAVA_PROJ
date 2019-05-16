package example02MethodDetails;

import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SystemAspect {

	@Before("execution( java.lang.Integer  example02MethodDetails.MyBean.*(..))")
	public void doAccessCheck(org.aspectj.lang.JoinPoint jp) {
		System.out.println("Before ASPECT: " + jp);
		Signature sign = jp.getSignature();
		System.out.println("\t\tMethod signature:" + sign);
		System.out.println("\t\tMethod signature modifiers:" + sign.getModifiers()); // java.lang.reflect.Modifier
		System.out.println("\t\tMethod signature DeclaringTypeName:" + sign.getDeclaringTypeName());
		System.out.println("\t\tMethod signature DeclaringType:" + sign.getDeclaringType());
		System.out.println("\t\tkind: " + jp.getKind());
		System.out.println("\t\tTarget: " + jp.getTarget().getClass().getSimpleName());
		System.out.println("\t\tThis: " + jp.getThis().getClass().getSimpleName());
		Object[] args = jp.getArgs();
		for (int i = 0; i < args.length; i++) {
			System.out.println("\t\targ:" + args[i].getClass().getSimpleName() + " value=" + args[i]);
			args[i] = new Integer(99);
		}
	}
}
