package performanceAndMonitoring.agent;

import java.io.FileInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.ProtectionDomain;

public class Agent {
	public static String pathToFixedClass = "Course.class";

	public static void agentmain(String agentArgs, Instrumentation inst)
			throws Exception {
		   inst.addTransformer(new MyTransformer(), true);
		   inst.retransformClasses(Class.forName("performanceAndMonitoring.agent.Course"));
		}

	public static void premain(String agentArgs, Instrumentation inst) {
		System.out.println("Java Transformer Agent Running");
		inst.addTransformer(new MyTransformer());
	}

	static class MyTransformer implements ClassFileTransformer {
		public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
				ProtectionDomain protectionDomain, byte[] classfileBuffer) {
			try {
				if (className.equals("performanceAndMonitoring/agent/Course")) {
					FileChannel fileChannel = new FileInputStream(pathToFixedClass).getChannel();
					ByteBuffer buffer = ByteBuffer.allocate((int) fileChannel.size());
					fileChannel.read(buffer);
					return buffer.array();
				}
			} catch (Exception e) {// handle }
				return null;
			}
			return null;
		}
	}
}