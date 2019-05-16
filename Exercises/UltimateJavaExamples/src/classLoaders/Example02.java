package classLoaders;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class Example02 {
	public static void main(String[] args) throws Exception {
		ClassLoader cl = new ClassLoader(null) {
			@Override
			protected Class<?> findClass(String name) throws ClassNotFoundException {
				if (name.equals("classLoaders.Test")) {
					// loading the bytecode and converting to Class
					try {
						URL url = ClassLoader.getSystemResource(name.replace(".", "/") + ".class");
						Path path = Paths.get(url.toURI());
						byte[] bt = Files.readAllBytes(path);
						String modified = new String(bt).replace("Constructor", "Monstructor");
						bt = modified.getBytes();
						return defineClass(name, bt, 0, bt.length);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
				return super.findClass(name);
			}
		};

		Class<?> clz = cl.loadClass("classLoaders.Test");
		// prints "class Test"
		System.out.println(clz.newInstance());
	}

}
